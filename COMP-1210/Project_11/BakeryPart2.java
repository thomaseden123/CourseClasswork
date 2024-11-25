import java.io.FileNotFoundException; 

/**
 * BakeryPart2 class only has a main method.
 * @author - Thomas Eden
 * @version - November 11, 2022
 */

public class BakeryPart2 {

/**
 * Reads in the file name as the first argument, args[0], 
 * of the command line arguments, creates an instance of BakedItemList, 
 * and then calls the readItemFile method in the 
 * BakedItemList class to read in the data file and generate the five reports.
 * @param args - used to get BakedItemList input
 * @throws FileNotFoundException if the file cannot be opened.
 */

   public static void main(String[] args) 
                     throws FileNotFoundException {
      if (args.length == 0) {
         System.out.print("File name expected as command line argument.\n");
         System.out.print("Program ending.\n");
      } else {
         BakedItemList bList = new BakedItemList();
         bList.readItemFile(args[0]);
         System.out.println(bList.generateReport());
         System.out.println(bList.generateReportByClass());  
         System.out.println(bList.generateReportByFlavor()); 
         System.out.println(bList.generateExcludedRecordsReport());      
      }    
   }
}