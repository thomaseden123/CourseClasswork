import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests values for Pie.
 * @author - Thomas Eden
 * @version - November 4, 2022
 */


public class PieTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   /** Test for getCrustCost of a pie. **/   
   @Test public void getCrustCostTest() {
      Pie p1 = new Pie("Weekly Special", "Apple", 1, 0,
                        "flour", "sugar", "apples", "cinnamon",
                        "butter", "baking soda", "salt");
      Pie p2 = new Pie("Summer Special", "Key Lime", 1, 2.0,
                        "flour", "sugar", "lime juice", "lemon juice",
                        "graham crackers", "butter", "baking soda", "salt");
      Assert.assertEquals(0, p1.getCrustCost(), 0.01);  
      Assert.assertEquals(2.0, p2.getCrustCost(), 0.01);                  
   }
   
   /** Test for setCrustCost of a pie. **/
   @Test public void setCrustCostTest() {
      Pie p1 = new Pie("Weekly Special", "Apple", 1, 0,
                        "flour", "sugar", "apples", "cinnamon",
                        "butter", "baking soda", "salt");
      Pie p2 = new Pie("Summer Special", "Key Lime", 1, 2.0,
                        "flour", "sugar", "lime juice", "lemon juice",
                        "graham crackers", "butter", "baking soda", "salt");
      p1.setCrustCost(0);
      p2.setCrustCost(2.0);                  
      Assert.assertEquals(0, p1.getCrustCost(), 0.01);  
      Assert.assertEquals(2.0, p2.getCrustCost(), 0.01);                  
   }
   
   /** Test for the price of a pie. **/
   @Test public void priceTest() {
      Pie p1 = new Pie("Weekly Special", "Apple", 1, 0,
                        "flour", "sugar", "apples", "cinnamon",
                        "butter", "baking soda", "salt");
      Pie p2 = new Pie("Summer Special", "Key Lime", 1, 2.0,
                        "flour", "sugar", "lime juice", "lemon juice",
                        "graham crackers", "butter", "baking soda", "salt");
      Assert.assertEquals(12.00, p1.price(), 0.001);  
      Assert.assertEquals(14.00, p2.price(), 0.001);                
   }
   
}
