/**********************************************************\                   
 * Author  : Thomas Eden                                   *         
 * Date    : September 10, 2024                            *                   
 * Purpose : For Hands-On Lab 2 Introduction to OS         *                   
 **********************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <sys/mman.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>

/**********************************************************\
 * Function: Runs 4 processes. Parent creates 3 children   *
 *           Each child process runs an infinite loop      *
 * argument: none                                          *
 * output  : nothing                                       *
 **********************************************************/


int main(){
  int pid;        /* Process ID                           */
  int i;          /* Just an iteration variable           */
 

  setbuf(stdout,NULL);
  pid = getpid(); /* Parent process gets its process ID   */
  printf("Parent Process ID is %d\n",pid);
  for (i = 1; i <= 3; i++) {
    pid = fork();
    if (pid < 0){
      printf("Unable to fork a process\n");
      exit(1);
    }

    if (pid == 0) {
      /* The child process starts here                     */
      pid = getpid();
      printf("Child %d with Process ID %d\n",i,pid);
      while (1); /* Infinite loop */
    } /* if (pid == 0) */
  } /* for (int i = 1; i <= 4; i++) */
  while (1); /* Infinite loop */
  exit(0); /* Will never run */
}









