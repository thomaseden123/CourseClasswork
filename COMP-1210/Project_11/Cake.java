  /**
 * Represents info about a cake.
 * Cake is a subclass of BakedItem.
 * @author - Thomas Eden
 * @version - November 4, 2022
 */

public class Cake extends BakedItem {

   protected int layers = 0;
  /** Base rate for all cakes. */
   public static final double BASE_RATE = 8;
   
   /**
    * Cake constructor sets name, flavor, 
    * quantity, layers, and ingredients.
    * @param nameIn initializes name variable in Cake
    * @param flavorIn initializes flavor variable in Cake
    * @param quantityIn initializes quantity variable in Cake
    * @param layersIn initializes layers variable in Cake
    * @param ingredientsIn initializes ingredients variable in Cake
    */
   
   public Cake(String nameIn, String flavorIn,
          int quantityIn, int layersIn,
          String...ingredientsIn) {
          
      super(nameIn, flavorIn, quantityIn, ingredientsIn);
      layers = layersIn;       
   }
   
   /**
    * Getter for the layers of a cake.
    * @return layers of cake
    */
   
   public int getLayers() {
      return layers;
   }
   
   /**
    * Setter for the layers of a cake 
    * and returns nothing.
    * @param layersIn as int for Cake
    */
   
   public void setLayers(int layersIn) {
      layers = layersIn;
   }
   
   /**
    * Accepts no parameters and returns a double
    * representing the price for a Cake.
    * @return price of Cake
    */
   
   public double price() {
      return (BASE_RATE * layers) * quantity;
   }
   

}
