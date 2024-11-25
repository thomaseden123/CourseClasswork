import java.util.Scanner;

/**
 * Prints user's math problem answer.
 *
 * @author - Thomas Eden
 * @version - August 31, 2022
 */


public class MySolver {

/**
  * Prints answer of math problem to std output.  
  * @param args - not used.
  */


   public static void main(String[] args) {
   
      Scanner userInput = new Scanner(System.in);
      double userResult = 0;
      double x = 0;
      double y = 0;
      double z = 0;
      
      System.out.println("result = (8.5x + 6.1) (10y + 7.9) / z");
      System.out.print("\tEnter x: ");
      x = userInput.nextDouble();
      System.out.print("\tEnter y: ");
      y = userInput.nextDouble();
      System.out.print("\tEnter z: ");
      z = userInput.nextDouble();
      if (z == 0) {
         System.out.print("result is undefined.");
         
      } else {
         userResult = (8.5 * x + 6.1) * (10 * y + 7.9) / z;
         System.out.println("result = " + userResult);
         
      }
   }

}