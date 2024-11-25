   /**
 * Represents info for online text items.
 * @author - Thomas Eden
 * @version - November 1, 2022
 */

public abstract class OnlineTextItem extends InventoryItem {

  /**
    * Set up constructor for OnlineTextItem.
    * @param nameIn - name
    * @param priceIn - price
    */

   public OnlineTextItem(String nameIn, double priceIn) {
      super(nameIn, priceIn);
   }
   
   /**
    * Calculates the cost of the item.
    * @return price of the item
    */
   
   public double calculateCost() {
      return price;
   }

}