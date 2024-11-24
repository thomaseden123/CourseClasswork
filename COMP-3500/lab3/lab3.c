
/*****************************************************************************\
* Laboratory Exercises Introduction to Operating Systems                      *
* Author: Thomas Eden                                                           *
* Date  : October 1, 2024                                                   *
\*****************************************************************************/

/*****************************************************************************\
*                             Global system headers                           *
\*****************************************************************************/
#include <stdio.h>
#include <stdlib.h>
#include <sys/select.h>
#include <sys/time.h>
#include <math.h>
#include <limits.h>
#include <signal.h>
#include <sys/wait.h>
#include <string.h>

#include <unistd.h>   /* for getpid, read, write, fork                       */



/*****************************************************************************\
*                             Global data types                               *
\*****************************************************************************/
typedef int             Identifier;
typedef short           Flag;
typedef int             Status;
typedef double          Timestamp;
typedef double          TimePeriod;
typedef unsigned int    Quantity;
typedef double          Average;




/*****************************************************************************\
*                             Global definitions                              *
\*****************************************************************************/
#define  MAXNUMBERPROCESSES 1000     /* Maximum number of processes            */
#define  MINTIMEEXPERIMENT  120.0   /* Minimum Time To Evaluate               */
#define  FALSE               0     /* False condition                        */
#define  TRUE                1     /* True condition                         */

/*****************************************************************************\
*                            Global data structures                           *
\*****************************************************************************/




/*****************************************************************************\
*                                  Global data                                *
\*****************************************************************************/
Quantity   NumberProcesses;      /* Number of Competing Processes          */
Identifier ProcessIDs[MAXNUMBERPROCESSES];
                                   // Array of Process IDs                   
TimePeriod ExperimentDuration;   /* Time in seconds experiment lasts       */
Flag       Show;                 /* If TRUE, displays extra information    */
Flag       GreenLight;           /* If true, Process starts its task       */
Timestamp  StartTime;            /* Start time of emulation                */
Timestamp  GreenLightTime;       /* Time process gets green light to start */
Identifier ParentID;             /* Process ID of Parent (Control)         */
FILE       *fileData;            /* File Pointer To Store Data             */

/*****************************************************************************\
*                               Function prototypes                           *
\*****************************************************************************/
Flag        Initialization(int argc, char **argv);
Timestamp   Now(void);     
Flag        LaunchExperiment(void);
static void StartProcessTask(int signo);
static void StopProcessTask(int signo);
void        ProcessData(void);

/*****************************************************************************\
* function: main()                                                            *
* usage:    Launches n processes that execute the same task                   *
*           Starts all processes almsot a the same time                       *
*           Let all processes to run for some time                            *
*           When time is over, record the percentage of task completed        *
*******************************************************************************
* Inputs: ANSI flat C command line parameters                                 *
* Output: None                                                                *
\*****************************************************************************/

int main (int argc, char **argv) {
   if (Initialization(argc,argv)){
     LaunchExperiment();
   }
} /* end of main function */

/*****************************************************************************\
* function: LaunchExperiment()                                                *                                 
* usage:    Launches the experiment                                           *                             
*******************************************************************************                              
* Input    : None                                                             *                             
* Output   : None                                                             *                        
* Function : Fork NumberProcesses processes to execute a task and collect     *                                
*            the percentage of task performed by each process                 *                       
\*****************************************************************************/
Flag LaunchExperiment(void){
  int i;
  Identifier pid;
  Status status;

  //SB_
  // Timestamp NowRecord;


  for (i=0; i < NumberProcesses; i++){
    pid = fork();
    if (pid < 0){
      printf("Cannot fork Process %d - Abort\n", i);
      exit(1);
    }
    if (pid == 0) { //Child process

      while (!GreenLight); // Child waits until green light
      GreenLightTime = Now();
      printf("Process %d start at %f\n",getpid(),GreenLightTime);

      Quantity c, c2;
      double x;
      Timestamp NowRecord = Now();
      for (c = 0; (c < 0xffffffff) && ((NowRecord - GreenLightTime) < ExperimentDuration); c++)
	for (c2 = 0; (c2 < 20000) && ((NowRecord - GreenLightTime) < ExperimentDuration); c2++){
		x = 3.14 * 67.23;
		NowRecord = Now();
        }
      
      printf("Process %d computed for %f seconds and reached %d\n",
      getpid(), NowRecord - GreenLightTime, c);
      fprintf(fileData,"%d\n",c); /* write c in file data                       */
      exit(1); // Just by precaution exits without creating grandchildren
    } else { // Parent Child
      ProcessIDs[i] = pid; // record the process ID of child just created
    }
  }
  // List and "green light" processes of created children
  for (i=0; i < NumberProcesses; i++){
    // printf("Process ID is %d\n",ProcessIDs[i]);
    kill(ProcessIDs[i],SIGUSR1);
  }
  printf("Please wait for %5.0f seconds ..............\n",ExperimentDuration);
  // Wait for all children to terminate
  for (i=0; i < NumberProcesses; i++){
    waitpid(ProcessIDs[i], &status, 0); // Wait for children to terminate
  }
  fclose(fileData);
  ProcessData();
  exit(0); //Parent exists
}

/***********************************************************************\                               
 * Input    : Standard command line parameters                           *                               
 * Output   : Returns a flag TRUE if everything went ok                  *                               
 * Function : Initialize global variables, structures.                   *                               
\***********************************************************************/

Flag Initialization(int argc, char **argv){

  if (argc != 3) {
    printf("usage: command NumberProcesses NumberMinutes\n");
    return(FALSE);
  }

  NumberProcesses    = (Quantity) atoi(argv[1]);
  if (NumberProcesses > MAXNUMBERPROCESSES){
    printf("No more than %d processes\n",MAXNUMBERPROCESSES);
    return(FALSE);
  }

  ExperimentDuration = (TimePeriod) 60.0 * atoi(argv[2]);
  if (ExperimentDuration < MINTIMEEXPERIMENT){
    printf("Need at least 2 minutes\n");
    return(FALSE);
  }

  StartTime           = Now();
  ParentID            = getpid();
  GreenLight          = FALSE;
  signal(SIGUSR1,StartProcessTask);

  printf("Now is %f,  Number of processes is %d, Experiment Duration is %f\n", 
	Now(),NumberProcesses, ExperimentDuration);

  fileData = fopen("file.dat","w");
  if (fileData == NULL){
    printf("Cannot Open File\n");
    exit(1);
  }

  return(TRUE);

 }

/***********************************************************************\                                  
* Input : none                                                          *                                 
* Output: Displays average and variance of c (higher value reached)     *                                  
* Function: compute average and variance of c                           *                                 
\***********************************************************************/
void ProcessData(void){
  Quantity *Array = calloc(NumberProcesses,sizeof(Quantity));
  Average AvgC, VarC, temp, stdDev; /*Average and Variance of c */
  FILE *fptr;
  int i;
  
  fptr = fopen("file.dat","r");
  if (fptr == NULL){
    printf("Cannot open file.dat\n");
    exit(1);
  }
  AvgC = 0.0;
  for (i=0; i < NumberProcesses;i++){
    fscanf(fptr,"%d",&Array[i]);
    printf("Process %d c= %d \n",i,Array[i]);
    AvgC += Array[i];
  }
  AvgC = AvgC / NumberProcesses;
  VarC = 0;
  for (i=0; i < NumberProcesses;i++){
    temp  = (Array[i]-AvgC);
    VarC += temp * temp;
  }
  stdDev = sqrt(VarC/NumberProcesses);
  printf("%d processses ran concurrently for %3.0f seconds\n ", NumberProcesses, ExperimentDuration);
  printf("Mean = %5.2f Standard Deviation (STDV) = %5.2f    Percentage STDV/Average =  %6.2f%\n", 
	 AvgC, stdDev, 100.0*stdDev/AvgC);
  fclose(fptr);
}

/***********************************************************************\                                 
* Input : signal number signo (we do not use signo)                     *                                
* Output: None                                                          *                                 
* Function: Turns on Greenlight to allow Process to start its task      *                                 
\***********************************************************************/
static void StartProcessTask(int signo){
  signal(SIGUSR1, StartProcessTask);
  // printf("Green Light Process %d at %f\n",getpid(), Now());
  GreenLight = TRUE;
}


/***********************************************************************\                                  
 * Input    : None                                                       *                                 
 * Output   : Returns the current system time                            *                                 
\***********************************************************************/
Timestamp Now(){
  struct timeval tv_CurrentTime;
  gettimeofday(&tv_CurrentTime,NULL);
  return( (Timestamp) tv_CurrentTime.tv_sec + (Timestamp) tv_CurrentTime.tv_usec / 1000000.0 - StartTime);
}
