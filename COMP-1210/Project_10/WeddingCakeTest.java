import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests values for WeddingCake.
 * @author - Thomas Eden
 * @version - November 4, 2022
 */


public class WeddingCakeTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** Test for getTiers of a wedding cake. **/
   @Test public void getTiersTest() {
      WeddingCake c3 = new WeddingCake("3-Layer/3-Tier", "Vanilla", 1, 3, 3,
                        "flour", "sugar", "buttermilk", "coffee",
                        "eggs", "butter", "baking soda", "baking powder", 
                        "salt");
      Assert.assertEquals(3, c3.getTiers());
   }
   
   /** Test for setTiers of a wedding cake. **/
   @Test public void setTiersTest() {
      WeddingCake c3 = new WeddingCake("3-Layer/3-Tier", "Vanilla", 1, 3, 3,
                        "flour", "sugar", "buttermilk", "coffee",
                        "eggs", "butter", "baking soda", "baking powder", 
                        "salt");
      c3.setTiers(3);                  
      Assert.assertEquals(3, c3.getTiers());
   }
   
   /** Test for the price of a wedding cake. **/
   @Test public void priceTest() {
      WeddingCake c3 = new WeddingCake("3-Layer/3-Tier", "Vanilla", 1, 3, 3,
                        "flour", "sugar", "buttermilk", "coffee",
                        "eggs", "butter", "baking soda", "baking powder", 
                        "salt");
      Assert.assertEquals(135.00, c3.price(), 0.001);                 
   }
   
}
