import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests values for RingTorus.
 * @author - Thomas Eden
 * @version - October 21, 2022
 */


public class RingTorusTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }
   
   /** Test for Set methods. **/
   @Test public void setTest() {
      RingTorus setting = new RingTorus("Set", 9.5, 1.25);
      Assert.assertTrue(setting.setLabel("Label"));
      Assert.assertTrue(setting.setLargeRadius(10.0));
      Assert.assertTrue(setting.setSmallRadius(3.0));
      Assert.assertFalse(setting.setLabel(null));
   }
   
   /** Test for LargeRadius. **/
   @Test public void getLargeRadiusTest() {
      RingTorus rt1 = new RingTorus("Large Radius Test", 9.5, 1.25);
      Assert.assertEquals(rt1.getLargeRadius(), 9.5, 0); 
   }
   
   /** Test for SmallRadius. **/
   @Test public void getSmallRadiusTest() {
      RingTorus rt1 = new RingTorus("Small Radius Test", 9.5, 1.25);
      Assert.assertEquals(rt1.getSmallRadius(), 1.25, 0); 
   }
   
   /** Test for Diameter. **/
   @Test public void diameterTest() {
      RingTorus rt1 = new RingTorus("Diameter", 9.5, 1.25);
      Assert.assertEquals(rt1.diameter(), 21.5, 0); 
   }
   
   /** Test for Surface Area. **/
   @Test public void surfaceAreaTest() {
      RingTorus rt1 = new RingTorus("Surface Area", 9.5, 1.25);
      Assert.assertEquals(rt1.surfaceArea(), 468.806, 0.01);
   }
   
   /** Test for Volume. **/
   @Test public void volumeTest() {
      RingTorus rt1 = new RingTorus("Volume", 9.5, 1.25);
      Assert.assertEquals(rt1.volume(), 293.004, 0.01);
   } 
   
   /** Test for toString. **/
   @Test public void toStringTest() {
      RingTorus rt1 = new RingTorus("toString", 9.5, 1.25);
      System.out.print(rt1.toString());   
      Assert.assertTrue(rt1.toString().contains("toString"));
   } 
   
   /** Test for counting how many Ring Toruses there are. **/
   @Test public void getCountTest() {
      RingTorus.resetCount();
      Assert.assertEquals(RingTorus.getCount(), 0);
      RingTorus rt1 = new RingTorus("test", 9.5, 1.25);
      RingTorus rt2 = new RingTorus("test", 9.5, 1.25);
      Assert.assertEquals(RingTorus.getCount(), 2);
      
   }
   
   /** 1st test for equals method. **/
   @Test public void equalsTest1() {
      RingTorus rt1 = new RingTorus("test", 9.5, 1.25);
      RingTorus rt2 = new RingTorus("test", 9.5, 1.25);
      Assert.assertTrue(rt1.equals(rt2));
      rt1 = new RingTorus("test", 7.5, 1.25);
      Assert.assertFalse(rt1.equals(rt2));
   }
   
   /** 2nd test for equals method. **/
   @Test public void equalsTest2() {
      RingTorus rt1 = new RingTorus("test", 9.5, 1.25);
      RingTorus rt2 = new RingTorus("test", 9.5, 1.25);
      Assert.assertTrue(rt1.equals(rt2));
      rt1 = new RingTorus("test", 9.5, 1.75);
      Assert.assertFalse(rt1.equals(rt2));
   }
   
   /** Test for hash code method. **/
   @Test public void hashCodeTest() {
      RingTorus rt1 = new RingTorus("test", 9.5, 1.25);
      Assert.assertEquals(0, rt1.hashCode());
      Assert.assertFalse(rt1.equals(rt1.hashCode()));
   }
     
   /** Test for compareTo method. **/
   @Test public void compareToTest() {
      RingTorus rt1 = new RingTorus("test", 9.5, 1.25);
      RingTorus rt2 = new RingTorus("test", 9.5, 1.25);
      RingTorus rt3 = new RingTorus("test", 11.5, 1.75);
      Assert.assertTrue("compareTo equals test", 
                    rt1.compareTo(rt2) == 0);
      Assert.assertTrue("compareTo < test",
                    rt1.compareTo(rt3) < 0);  
      Assert.assertTrue("compareTo > test",
                    rt3.compareTo(rt2) > 0);
   }
     
}