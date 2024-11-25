import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests values for Cake.
 * @author - Thomas Eden
 * @version - November 4, 2022
 */


public class CakeTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** Test for getLayers of a cake. **/
   @Test public void getLayersTest() {
     
      Cake c1 = new Cake("Birthday", "Chocolate", 1, 1,
                  "flour", "sugar", "cocoa powder", "vanilla", "eggs",
                  "butter", "baking soda", "baking powder", "salt");
      Cake c2 = new Cake("2-Layer", "Red Velvet", 1, 2,
                  "flour", "sugar", "cocoa powder", "food coloring", 
                  "eggs", "butter", "baking soda", "baking powder", 
                  "salt");
      Assert.assertEquals(1, c1.getLayers());
      Assert.assertEquals(2, c2.getLayers());
   }
   
   /** Test for setLayers of a cake. **/
   @Test public void setLayersTest() {
     
      Cake c1 = new Cake("Birthday", "Chocolate", 1, 1,
                  "flour", "sugar", "cocoa powder", "vanilla", "eggs",
                  "butter", "baking soda", "baking powder", "salt");
      Cake c2 = new Cake("2-Layer", "Red Velvet", 1, 2,
                  "flour", "sugar", "cocoa powder", "food coloring", 
                  "eggs", "butter", "baking soda", "baking powder", 
                  "salt");
      c1.setLayers(1);
      c2.setLayers(2);            
      Assert.assertEquals(1, c1.getLayers());
      Assert.assertEquals(2, c2.getLayers());
   }
   
   /** Test for the price of a cake. **/
   @Test public void priceTest() {
      Cake c1 = new Cake("Birthday", "Chocolate", 1, 1,
                  "flour", "sugar", "cocoa powder", "vanilla", "eggs",
                  "butter", "baking soda", "baking powder", "salt");
      Cake c2 = new Cake("2-Layer", "Red Velvet", 1, 2,
                  "flour", "sugar", "cocoa powder", "food coloring", 
                  "eggs", "butter", "baking soda", "baking powder", 
                  "salt");
      Assert.assertEquals(8.00, c1.price(), 0.001);  
      Assert.assertEquals(16.00, c2.price(), 0.001);                
   }
   
}
