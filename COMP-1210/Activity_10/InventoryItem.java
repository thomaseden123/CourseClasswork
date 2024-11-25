/**
 * Represents info for inventory items.
 * @author - Thomas Eden
 * @version - November 1, 2022
 */

public class InventoryItem {

   protected String name;
   protected double price;
   private static double taxRate = 0; // Tax rate for all inventory items
   
   /**
    * Set up constructor for InventoryItem.
    * @param nameIn - name
    * @param priceIn - price
    */
   
   public InventoryItem(String nameIn, double priceIn) {
      name = nameIn;
      price = priceIn;
      
   }
   
   /**
    * Gets the name of the item.
    * @return name
    */
   
   public String getName() {
      return name;
   }
   
   /**
    * Calculates the cost of the item.
    * @return price (with tax rate)
    */
   
   public double calculateCost() {
      return price * (1 + taxRate);
   }
   
   /**
    * Sets the constant word count of the book.
    * @param taxRateIn - taxRate
    */
   
   public static void setTaxRate(double taxRateIn) {
      taxRate = taxRateIn;
   }
   
   /**
    * Gives summary of the inventory item.
    * @return the String representation of InventoryItem
    */
   
   public String toString() {
      return name + ": $" + calculateCost();
   }
}