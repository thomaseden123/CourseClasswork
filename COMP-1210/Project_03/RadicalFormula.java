import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Solves a radical math equation.
 *
 * @author - Thomas Eden
 * @version - September 9, 2022
 */

public class RadicalFormula {

 /**
  * Solves equation using values and decimal format.  
  * @param args - not used.
  */

   public static void main(String[] args) {
   
   
      Scanner scan = new Scanner(System.in);
      double x = 0;
      double value1 = 0;
      double value2 = 0;
      double value3 = 0;
      double value4 = 0;
      double result = 0;
      int resultLength = 0;
      int index = 0;
      int left = 0;
      int right = 0;
      String results = " ";
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      System.out.print("Enter a value for x: ");
      
      // All values for math equation
      x = scan.nextDouble();
      value1 = (3 * Math.pow(x, 8)) - (2 * Math.pow(x, 3));
      value2 = Math.pow(value1, 2);
      value3 = (3 * Math.pow(x, 5)) - (2 * Math.pow(x, 3));
      value4 = Math.abs(value3);
      result = Math.sqrt(value2 + value4);
      
      // Prints out results for math equation
      System.out.println("Result: " + result);
      
      results = Double.toString(result);
      resultLength = results.length();
      index = results.indexOf('.');
      left = index;
      right = (resultLength - index - 1);
      
      System.out.println("# digits to left of decimal point: " + left);
      System.out.println("# digits to right of decimal point: " + right);
      System.out.println("Formatted Result: " + df.format(result));
      
   
   }
   
}