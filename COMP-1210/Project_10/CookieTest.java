import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests values for Cookie.
 * @author - Thomas Eden
 * @version - November 4, 2022
 */


public class CookieTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** Test for getName of a baked item (cookie). **/
   @Test public void getNameTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12, 
                        "flour", "sugar", "dark chocolate chips", 
                        "butter", "baking soda", "salt");
      Assert.assertEquals("Chips Delight", c.getName());
   }
   
   /** Test for setName of a baked item (cookie). **/
   @Test public void setNameTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12, 
                        "flour", "sugar", "dark chocolate chips", 
                        "butter", "baking soda", "salt");
      c.setName("Chips Delight");
      Assert.assertEquals("Chips Delight", c.getName());                  
   }
    
   /** Test for getFlavor of a baked item (cookie). **/
   @Test public void getFlavorTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12, 
                        "flour", "sugar", "dark chocolate chips", 
                        "butter", "baking soda", "salt");
      Assert.assertEquals("Chocolate Chip", c.getFlavor());
   } 
   
   /** Test for setFlavor of a baked item (cookie). **/
   @Test public void setFlavorTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12, 
                        "flour", "sugar", "dark chocolate chips", 
                        "butter", "baking soda", "salt");
      c.setFlavor("Chocolate Chip");
      Assert.assertEquals("Chocolate Chip", c.getFlavor());                  
   }
     
   /** Test for getQuantity of a baked item (cookie). **/
   @Test public void getQuantityTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12, 
                        "flour", "sugar", "dark chocolate chips", 
                        "butter", "baking soda", "salt");
      Assert.assertEquals(12, c.getQuantity());
   }
   
   /** Test for setQuantity of a baked item (cookie). **/                 
   @Test public void setQuantityTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12, 
                        "flour", "sugar", "dark chocolate chips", 
                        "butter", "baking soda", "salt");
      c.setQuantity(12);
      Assert.assertEquals(12, c.getQuantity());                  
   }  
                
   /** Test for getIngredients of a baked item (cookie). **/
   @Test public void getIngredientsTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12, 
                        "flour", "sugar", "dark chocolate chips", 
                        "butter", "baking soda", "salt");
      String[] test = {"flour", "sugar", "dark chocolate chips", 
                       "butter", "baking soda", "salt"};                  
      Assert.assertArrayEquals(test, c.getIngredients());   
                    
   }
   
   /** Test for setIngredients of a baked item (cookie). **/
   @Test public void setIngredientsTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12, 
                        "flour", "sugar", "dark chocolate chips", 
                        "butter", "baking soda", "salt");
      String[] array = {"flour", "sugar", "dark chocolate chips", 
                        "butter", "baking soda", "salt"};    
      c.setIngredients(array);                                
      Assert.assertArrayEquals(array, c.getIngredients());   
                    
   }
   
   /** Test for the price of a cookie. **/
   @Test public void priceTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12, 
                        "flour", "sugar", "dark chocolate chips", 
                        "butter", "baking soda", "salt");
      Assert.assertEquals(4.20, c.price(), 0.001);                  
   }
   
   /** Test for getCount of a baked item (cookie). **/
   @Test public void getCountTest() {
      Cookie.resetCount();
      Assert.assertEquals(Cookie.getCount(), 0);
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12, 
                        "flour", "sugar", "dark chocolate chips", 
                        "butter", "baking soda", "salt");
      Assert.assertEquals(Cookie.getCount(), 1);
      
   }
   
   /** Test for resetCount of a baked item (cookie). **/
   @Test public void resetCountTest() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12, 
                        "flour", "sugar", "dark chocolate chips", 
                        "butter", "baking soda", "salt");
      c.resetCount();
      Assert.assertEquals(0, c.getCount());                 
   }
   
   /** 1st test for toString of a baked item (cookie). **/
   @Test public void toStringTest1() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12, 
                        "flour", "sugar", "dark chocolate chips", 
                        "butter", "baking soda", "salt");
      System.out.print(c.toString());   
      Assert.assertTrue(c.toString().contains("Chocolate Chip"));
   }
   
   /** 2nd test for toString of a baked item (cookie). **/
   @Test public void toStringTest2() {
      Cookie c = new Cookie("Chips Delight", "Chocolate Chip", 12, 
                        "flour", "sugar", "dark chocolate chips", 
                        "butter", "baking soda");
      System.out.print(c.toString());   
      Assert.assertTrue(c.toString().contains("Chocolate Chip"));
   }
}
