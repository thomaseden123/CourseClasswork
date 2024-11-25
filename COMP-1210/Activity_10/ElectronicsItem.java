  /**
 * Represents info for electronic items.
 * @author - Thomas Eden
 * @version - November 1, 2022
 */

public class ElectronicsItem extends InventoryItem {
   
   protected double weight;
   
  /** Shipping cost for all electronic items. */
   public static final double SHIPPING_COST = 1.5; 
   
   /**
    * Set up constructor for ElectronicsItem.
    * @param nameIn - name
    * @param priceIn - price
    * @param weightIn - weight
    */
   
   public ElectronicsItem(String nameIn, double priceIn,
                     double weightIn) {
      super(nameIn, priceIn);  
      weight = weightIn; 
   }
   
   /**
    * Calculates the cost of the item.
    * @return super.calculateCost() + (SHIPPING_COST * weight);
    */
   
   public double calculateCost() {
      return super.calculateCost() + (SHIPPING_COST * weight);
   }   
}