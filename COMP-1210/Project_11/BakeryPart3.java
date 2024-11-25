import java.io.FileNotFoundException; 

/**
 * BakeryPart3 class only has a main method.
 * The main method should be modified to catch and handle a
 * FileNotFoundException if one is thrown in the readItemFile method. 
 * @author - Thomas Eden
 * @version - November 18, 2022
 */

public class BakeryPart3 {

/**
 * Reads in the file name as the first argument, args[0], 
 * of the command line arguments, creates an instance of BakedItemList, 
 * and then uses a try-catch statement to call the readItemFile method in the 
 * BakedItemList class to read in the data file and generate the five reports.
 * @param args - used to get readItemFile input from BakedItemList
 */

   public static void main(String[] args) {
   
      try {
         if (args.length == 0) {
            System.out.print("File name expected as command line argument.\n");
            System.out.print("Program ending.\n");
         } else {
            BakedItemList bList = new BakedItemList();
            bList.readItemFile(args[0]);
            System.out.println(bList.generateReport());
            System.out.println(bList.generateReportByClass()); 
            System.out.println(bList.generateReportByPrice()); 
            System.out.println(bList.generateReportByFlavor()); 
            System.out.println(bList.generateExcludedRecordsReport());
         }
      }
      catch (FileNotFoundException e) {
         System.out.print("Attempted to read file: " + args[0]
                                    + " (No such file or directory)"); 
         System.out.print("\nProgram ending.\n");                          
      }  
   
   }

}