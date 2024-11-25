  /**
 * Represents info about a cookie.
 * Cookie is a subclass of BakedItem.
 * @author - Thomas Eden
 * @version - November 4, 2022
 */

public class Cookie extends BakedItem {

  /** Base rate for all cookies. */
   public static final double BASE_RATE = 0.35;
   
   /**
    * Cookie constructor sets name, flavor, 
    * quantity, and ingredients.
    * @param nameIn initializes name variable in Cookie
    * @param flavorIn initializes flavor variable in Cookie
    * @param quantityIn initializes quantity variable in Cookie
    * @param ingredientsIn initializes ingredients variable in Cookie
    */
   
   public Cookie(String nameIn, String flavorIn,
               int quantityIn, String...ingredientsIn) {
               
      super(nameIn, flavorIn, quantityIn, ingredientsIn);
   }
   
   /**
    * Accepts no parameters and returns a double 
    * representing the price for a Cookie.
    * @return price of Cookie
    */
   
   public double price() {
      return BASE_RATE * quantity;
   }

}