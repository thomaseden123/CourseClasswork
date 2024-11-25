import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

/** 
 * HexagonalPrismListApp - uses HexagonalPrismList and HexagonalPrism classes.
 */

public class HexagonalPrismListApp {

/**
 * Reads file with hexagonal prism data, creates HexagonalPrismList, 
 * prints HexagonalPrismList, prints summary of HexagonalPrismList.
 *
 * @param args - not used.
 * @throws FileNotFoundException required by Scanner for File
 */
      
   public static void main(String[] args) throws FileNotFoundException {
      
      Scanner scan = new Scanner(System.in);
      ArrayList<HexagonalPrism> prismList = new ArrayList<HexagonalPrism>();
      String list = "";
      
      System.out.print("Enter file name: ");
      String fileName = scan.nextLine();
      Scanner scanFile = new Scanner(new File(fileName));
      list = scanFile.nextLine();
      
      while (scanFile.hasNext()) {
         String label = scanFile.nextLine();
         double edge = Double.parseDouble(scanFile.nextLine());
         double height = Double.parseDouble(scanFile.nextLine());
         HexagonalPrism hp = new HexagonalPrism(label, edge, height);
         prismList.add(hp);
         
      }  
      
      HexagonalPrismList hpList = new HexagonalPrismList(list, prismList);
      System.out.println();
      System.out.println(hpList);
      System.out.println();
      System.out.println(hpList.summaryInfo());   
         
      
   }
  

}