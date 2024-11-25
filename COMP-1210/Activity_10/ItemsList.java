   /**
 * Represents info for an item list.
 * @author - Thomas Eden
 * @version - November 8, 2022
 */

public class ItemsList {

   private InventoryItem[] inventory;
   private int count;
   
   /**
    * Set up constructor for ItemsList.
    */
   
   public ItemsList() {
   
      inventory = new InventoryItem[20];
      count = 0;
   
   }
   
   /**
    * Adds an item to the item list and returns nothing. 
    * @param itemIn as inventoryItem
    */
   
   public void addItem(InventoryItem itemIn) {
      inventory[count] = itemIn; 
      count++;  
   }
   
   /**
    * Calculates total cost of each item in the list.
    * @param electronicsSurcharge as double
    * @return total
    */
   
   public double calculateTotal(double electronicsSurcharge) {
      double total = 0;
      for (int i = 0; i < count; i++) {
         if (inventory[i] instanceof ElectronicsItem) {
            total += inventory[i].calculateCost() + electronicsSurcharge;
         } else {
            total += inventory[i].calculateCost();
         }   
      } 
      return total;     
   }
   
   /**
    * Gives summary of the inventory item list.
    * @return the String representation of ItemsList
    */
   
   public String toString() {
      String output = "All inventory:\n\n";
      
      for (int i = 0; i < count; i++) {
         output += inventory[i] + "\n";
      }
      
      return output;
   }
}