/**
 * Main code for Division class.
 * @author - Thomas Eden
 * @version - November 15, 2022
 */

public class Division {

   /**
    * Divides the int num (numerator) by the int (denominator).
    * @param numIn as int for num (numerator)
    * @param denomIn as int for denom (denominator)
    * @return result of num divided by denom
    */

   public static int intDivide(int numIn, int denomIn) {
   
      int num = numIn;
      int denom = denomIn;
      
      try
      {
         return num / denom;
      }
      catch (ArithmeticException e)
      {
         return 0;
      }      
      
   }
   
   /**
    * Divides the int num by the int denom
    * and returns the result as a double.
    * @param numIn as int for num
    * @param denomIn as int for denom
    * @return output of numerator divided by denominator as a double
    */
   
   public static double decimalDivide(int numIn, int denomIn) {
   
      double numerator = (double) numIn;
      double denominator = (double) denomIn;
    
      if (denominator == 0) {
         throw new IllegalArgumentException("The denominator "
               + "cannot be zero.");
      } else {
      
         return (double) numerator / denominator;
         
      }   
      
   }
   
}