import java.text.DecimalFormat;

/**
 * Represents info about a baked item.
 * @author - Thomas Eden
 * @version - November 4, 2022
 */


public abstract class BakedItem implements Comparable<BakedItem> {
   protected String name;
   protected String flavor;
   protected int quantity;
   protected String[] ingredients;
   protected static int count;
   
   /**
    * BakedItem constructor sets name, flavor, 
    * quantity, and ingredients.
    * Increments count.
    * @param nameIn initializes name variable in BakedItem
    * @param flavorIn initializes flavor variable in BakedItem
    * @param quantityIn initializes quantity variable in BakedItem
    * @param ingredientsIn initializes ingredients variable in BakedItem
    */
   
   public BakedItem(String nameIn, String flavorIn,
               int quantityIn, String...ingredientsIn) {
      
      name = nameIn;
      flavor = flavorIn;
      quantity = quantityIn;
      ingredients = ingredientsIn;
      count++;            
   }   
   
   /**
    * Getter for the name of the baked item.
    * @return name of baked item
    */
   
   public String getName() {
      return name;
   }
   
   /**
    * Setter for the name of the baked item 
    * and returns nothing.
    * @param nameIn initializes name variable in BakedItem
    */
   
   public void setName(String nameIn) {
      name = nameIn;
   }    
   
   /**
    * Getter for the flavor of the baked item.
    * @return flavor of baked item
    */
   
   public String getFlavor() {
      return flavor;
   }
   
   /**
    * Setter for the flavor of the baked item 
    * and returns nothing.
    * @param flavorIn initializes flavor variable in BakedItem
    */
   
   public void setFlavor(String flavorIn) {
      flavor = flavorIn;
   }
   
   /**
    * Getter for the quantity of the baked item.
    * @return quantity of baked item
    */
   
   public int getQuantity() {
      return quantity;
   }
   
   /**
    * Setter for the quantity of the baked item 
    * and returns nothing.
    * @param quantityIn initializes quantity variable in BakedItem
    */
   
   public void setQuantity(int quantityIn) {
      quantity = quantityIn;
   }
   
   /**
    * Getter for the ingredients of the baked item.
    * @return ingredients of baked item
    */
   
   public String[] getIngredients() {
      return ingredients;
   }
   
   /**
    * Setter for the ingredients of the baked item 
    * and returns nothing.
    * @param ingredientsIn initializes ingredients variable in BakedItem
    */
   
   public void setIngredients(String...ingredientsIn) {
      ingredients = ingredientsIn;
   }
   
   /**
    * Gets static count of baked items created.
    * @return count
    */
   
   public static int getCount() {
      return count;
   }
   
   /**
    * Resets count to zero and returns nothing.
    */
   
   public static void resetCount() {
      count = 0;
   }
   
   /**
    * Gives a final summary of each baked item and
    * returns each output as a String.
    * @return output as String describing the BakedItem object.
    */
   
   public final String toString() {
      String output = "";
      DecimalFormat df = new DecimalFormat("$#,##0.00");
      output += this.getClass().toString().substring(6) + ": ";
      output += getName() + " - " + getFlavor();
      output += "   " + "Quantity: " + getQuantity();
      output += "   " + "Price: " + df.format(price());
      output += "\n(Ingredients: ";
      for (int i = 0; i < ingredients.length; i++) {
         
         if (i != 0) {
            output += ", ";
         }
         
         if (i % 5 == 0 && i != 0) {
            output += "\n";
         }
         
         output += ingredients[i];
         
      } 
      output += ")";
      return output;     
            
   }  
   
   /**
    * An abstract method that accepts no parameters 
    * and returns a double representing the price
    * for a BakedItem.
    * @return price of BakedItem
    */
   
   public abstract double price(); 
   
   /**
    * Takes a BakedItem as a parameter and returns an int indicating the 
    * ordering from lowest to highest based on the
    * class name followed name, and flavor.
    * @param item is being initialized for BakedItem
    * @return compareTo values as int
    */
   
   public int compareTo(BakedItem item) {
      return this.toString().
               toUpperCase().compareTo(item.toString().toUpperCase());
   }


}