import java.util.Scanner;

/**
 * Prints user's laser measurement.
 *
 * @author - Thomas Eden
 * @version - August 31, 2022
 */

public class LaserMeasure {

  /**
    * Prints laser measurement to std output.  
    * @param args - not used.
    */

   public static void main(String[] args) {
   
      Scanner userInput = new Scanner(System.in);
      int distInch = 0;
   
   
      System.out.print("Enter the raw distance measurement in inches: ");
      distInch = userInput.nextInt();
      if (distInch < 0) {
         System.out.println("Measurement must be non-negative!");
         
      } else {     
      
         System.out.println();
         System.out.println("Measurement by combined " 
                  + "miles, yards, feet, inches: ");
      
         System.out.println("\tmiles: " 
               + distInch / 63360);
         System.out.println("\tyards: " 
               + distInch % 63360 / 36); 
         System.out.println("\tfeet: " 
               + distInch % 63360 % 36 / 12);
         System.out.println("\tinches: " 
               + distInch % 63360 % 36 % 12);
         System.out.println();
         System.out.print(distInch + " in = " + distInch / 63360 + " mi, ");
         System.out.print((distInch % 63360 / 36) + " yd, ");
         System.out.print((distInch % 63360 % 36 / 12) + " ft, ");
         System.out.print((distInch % 63360 % 36 % 12) + " in");              
         
      }                                 
               
   }
   
}