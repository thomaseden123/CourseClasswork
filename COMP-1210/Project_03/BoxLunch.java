import java.util.Scanner;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * Calculates cost of lunch in a box.
 *
 * @author - Thomas Eden
 * @version - September 9, 2022
 */

public class BoxLunch {

/**
  * Calulates lunch cost for adults and children in total.  
  * @param args - not used.
  */

   public static void main(String[] args) {
   
     // Variables
      Scanner userInput = new Scanner(System.in);
      String order = " ";
      int theme = 0;
      int numberAdultMeal = 0;
      double priceAdultMeal = 0;
      int numberChildMeal = 0;
      double priceChildMeal = 0;
      double totalPrice = 0;
      int lucky = 0;
      String name = " ";
      double total = 0;
      DecimalFormat df = new DecimalFormat("$#,##0.00");
      DecimalFormat pf = new DecimalFormat("0000");
      Random generator = new Random();
      lucky = generator.nextInt(10000);
      
      
      // Enter order code
      System.out.print("Enter order code: ");
      order = userInput.nextLine();
      order = order.trim();
      
      
                 
      // If-Else Statements  
      if (order.length() < 13) {
      
         System.out.println();
         System.out.println("*** Invalid Order Code ***");
         System.out.println("Order code must have at least 13 characters.");  
         
      } else {
         
         theme = Integer.parseInt(order.substring(0, 1));
         numberAdultMeal = Integer.parseInt(order.substring(1, 3));
         priceAdultMeal = (Double.parseDouble(order.substring(3, 7)) / 100);
         numberChildMeal = Integer.parseInt(order.substring(7, 9));
         priceChildMeal = (Double.parseDouble(order.substring(9, 13)) / 100);
         name = order.substring(13);
         totalPrice = (numberAdultMeal * priceAdultMeal) 
                 + (numberChildMeal * priceChildMeal);
         System.out.println();
         System.out.println("Name: " + name);
         System.out.println("Adult meals: " + numberAdultMeal + " at " 
                        + df.format(priceAdultMeal));
         System.out.println("Child meals: " + numberChildMeal + " at " 
                        + df.format(priceChildMeal));
         System.out.println("Total: " + "$" + totalPrice);
         
         // Theme
         if (theme == 0) {
            System.out.println("Theme: Birthday");
         } else if (theme == 1) {
            System.out.println("Theme: Graduation");
         } else {
            System.out.println("Theme: Holiday");
         
         }
         
         // Lucky Number
         System.out.println("Lucky Number: " + lucky);
         
      }
      
        
   }

}