   /**
 * Represents info about a pie.
 * Pie is a subclass of BakedItem.
 * @author - Thomas Eden
 * @version - November 4, 2022
 */

public class Pie extends BakedItem {

   private double crustCost;
  /** Base rate for all pies. */
   public static final double BASE_RATE = 12.0;
   
   /**
    * Pie constructor sets name, flavor, 
    * quantity, crust cost, and ingredients.
    * @param nameIn initializes name variable in Pie
    * @param flavorIn initializes flavor variable in Pie
    * @param quantityIn initializes quantity variable in Pie
    * @param crustCostIn initializes crustCost variable in Pie
    * @param ingredientsIn initializes ingredients variable in Pie
    */

   public Pie(String nameIn, String flavorIn,
               int quantityIn, double crustCostIn,
               String...ingredientsIn) {
               
      super(nameIn, flavorIn, quantityIn, ingredientsIn);      
      crustCost = crustCostIn;     
   } 
   
   /**
    * Getter for the crust cost of a pie.
    * @return crust cost of pie
    */
   
   public double getCrustCost() {
      return crustCost;
   } 
   
   /**
    * Setter for the crust cost of a pie 
    * and returns nothing.
    * @param crustCostIn initializes crustCost variable in Pie
    */          
   
   public void setCrustCost(double crustCostIn) {
      crustCost = crustCostIn;
   }
   
   /**
    * Accepts no parameters and returns a double
    * representing the price for a Pie.
    * @return price of Pie
    */
   
   public double price() {
      return (BASE_RATE + crustCost) * quantity;
   }

}