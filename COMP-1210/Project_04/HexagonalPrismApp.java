import java.util.Scanner;

/**
 * Prints values from HexagonalPrism.
 *
 * @author - Thomas Eden
 * @version - September 16, 2022
 */


public class HexagonalPrismApp {

/**
 * Reads values set in HexagonalPrism.
 * @param args - not used.
 */
   
   public static void main(String[] args) {
      
      Scanner scan = new Scanner(System.in);
      String label = " ";
      double edge = 0;
      double height = 0;
      System.out.println("Enter label, edge, and height "
               + "for a hexagonal prism.");
      System.out.print("\tlabel: ");
      label = scan.nextLine();
      System.out.print("\tedge: ");
      edge = scan.nextDouble();
      if (edge <= 0) {
      
         System.out.println("Error: edge must be greater than zero.");
         
      } else {
         
         System.out.print("\theight: ");
         height = scan.nextDouble();
         if (height <= 0) {
            
            System.out.println("Error: height must be greater than zero.");
            
         } else {
         
            System.out.println();
            HexagonalPrism prism = new HexagonalPrism(label, edge, height);
            System.out.print(prism);        
         }
         
      } 
   
         
      
   }

}