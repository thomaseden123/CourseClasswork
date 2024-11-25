  /**
 * Represents info about a wedding cake.
 * WeddingCake is a subclass of Cake.
 * @author - Thomas Eden
 * @version - November 4, 2022
 */

public class WeddingCake extends Cake {

   private int tiers;
  /** Base rate for all wedding cakes. */
   public static final double BASE_RATE = 15.0;
   
   /**
    * WeddingCake constructor sets name, flavor, 
    * quantity, layers, tiers, and ingredients.
    * @param nameIn initializes name variable in WeddingCake
    * @param flavorIn initializes flavor variable in WeddingCake
    * @param quantityIn initializes quantity variable in WeddingCake
    * @param layersIn initializes layers variable in WeddingCake
    * @param tiersIn initializes tiers variable in WeddingCake
    * @param ingredientsIn initializes ingredients variable in WeddingCake
    */
   
   public WeddingCake(String nameIn, String flavorIn,
          int quantityIn, int layersIn, int tiersIn,
          String...ingredientsIn) {
          
      super(nameIn, flavorIn, quantityIn, layersIn, ingredientsIn);
      tiers = tiersIn;       
   }
   
   /**
    * Getter for the tiers of a wedding cake.
    * @return tiers of wedding cake
    */
   
   public int getTiers() {
      return tiers;
   }
   
   /**
    * Setter for the tiers of a wedding cake 
    * and returns nothing.
    * @param tiersIn initializes tiers variable in WeddingCake
    */
   
   public void setTiers(int tiersIn) {
      tiers = tiersIn;
   }
   
   /**
    * Accepts no parameters and returns a double
    * representing the price for a WeddingCake.
    * @return price of WeddingCake
    *
    */
   
   public double price() {
      return (BASE_RATE * layers * tiers) * quantity;
   }

}