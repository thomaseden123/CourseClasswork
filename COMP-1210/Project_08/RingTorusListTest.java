import org.junit.Assert;
//import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests values for RingTorusList.
 * @author - Thomas Eden
 * @version - October 29, 2022
 */

public class RingTorusListTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }

   /** Test for getName. **/
   @Test public void getNameTest() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3}; 
      int num = torusList.length;
      RingTorusList torus = new RingTorusList("exp", torusList, num);
      Assert.assertEquals("exp", torus.getName());
   }
   
   /** Test for number of ring toruses. **/
   @Test public void numberOfRingTorusesTest() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      int num = torusList.length;
      RingTorusList torus = new RingTorusList("exp", torusList, num);
      Assert.assertEquals(num, torus.numberOfRingToruses());
   }
   
   /** Test for total diameter. **/
   @Test public void totalDiameterTest() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      int num = torusList.length;
      RingTorusList torus = new RingTorusList("exp", torusList, num);
      Assert.assertEquals(torus.totalDiameter(), 445.98, 0.01);
   }
   
   /** Test for total surface area. **/
   @Test public void totalSurfaceAreaTest() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      int num = torusList.length;
      RingTorusList torus = new RingTorusList("exp2", torusList, num);
      Assert.assertEquals(torus.totalSurfaceArea(), 186955.724, 0.01);
   }
    
    /** Test for total volume. **/     
   @Test public void totalVolumeTest() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      int num = torusList.length;
      RingTorusList torus = new RingTorusList("exp3", torusList, num);
      Assert.assertEquals(torus.totalVolume(), 2868020.119, 0.01);
   }
   
   /** Test for average diameter. **/
   @Test public void averageDiameterTest() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      int num = torusList.length;
      RingTorusList torus = new RingTorusList("exp", torusList, num);
      Assert.assertEquals(torus.averageDiameter(), 148.66, 0.01);
   }
   
   /** Test for average surface area. **/
   @Test public void averageSurfaceAreaTest() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      int num = torusList.length;
      RingTorusList torus = new RingTorusList("exp2", torusList, num);
      Assert.assertEquals(torus.averageSurfaceArea(), 62318.575, 0.01);
   }
   
   /** Test for average volume. **/
   @Test public void averageVolumeTest() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      int num = torusList.length;
      RingTorusList torus = new RingTorusList("exp3", torusList, num);
      Assert.assertEquals(torus.averageVolume(), 956006.706, 0.01);
   }
   
   /** Test for toString. **/
   @Test public void toStringTest() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      int num = torusList.length;
      RingTorusList torus = new RingTorusList("exp", torusList, num);
      System.out.print(torus.toString());   
      Assert.assertTrue(torus.toString().contains("exp"));
   }
   
   /** Test for getList. **/
   @Test public void getListTest() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      int num = torusList.length;
      RingTorusList torus = new RingTorusList("exp", torusList, num);
      Assert.assertEquals(torusList, torus.getList());
   }
   
   /** Test for adding ring toruses. **/
   @Test public void addRingTorusTest() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = new RingTorus[4];
      RingTorusList torus = new RingTorusList("exp", torusList, 3);
      RingTorus test = new RingTorus("ex4", 13.4, 5.3);
      torus.addRingTorus("ex4", 13.4, 5.3);
      Assert.assertEquals(test, torusList[3]);
   }
   
   /** 1st test for finding ring toruses. **/
   @Test public void findRingTorusTest1() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      int num = torusList.length;
      RingTorusList torus = new RingTorusList("exp3", torusList, num);
      Assert.assertEquals(torusList[1], torus.findRingTorus("ex2")); 
   }
   
   /** 2nd test for finding ring toruses. **/
   @Test public void findRingTorusTest2() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      int num = torusList.length;
      RingTorusList torus = new RingTorusList("exp3", torusList, num);
      RingTorus ex21 = new RingTorus("none", 25.3, 8.1);
      Assert.assertEquals(null, torus.findRingTorus(ex21.getLabel())); 
   }
   
   /** 1st test for deleting ring toruses. **/
   @Test public void deleteRingTorusTest1() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      RingTorusList torus = new RingTorusList("exp", torusList, 3);
      torus.deleteRingTorus("ex3");
      torus.getList();
      Assert.assertEquals(null, torus.deleteRingTorus("ex3"));
      Assert.assertEquals(null, torusList[2]);
   }
   
   /** 2nd test for deleting ring toruses. **/
   @Test public void deleteRingTorusTest2() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      int num = torusList.length;
      RingTorusList torus = new RingTorusList("exp", torusList, num);
      Assert.assertEquals(null, torus.deleteRingTorus("no exp"));
   }
   
   /** 1st test for editing ring toruses. **/
   @Test public void editRingTorusTest1() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      int num = torusList.length;
      RingTorusList torus = new RingTorusList("exp", torusList, num);
      double lRad = 148.72;
      double sRad = 35.87;
      Assert.assertTrue(torus.editRingTorus("ex3", lRad, sRad));
      Assert.assertEquals(148.72, ex3.getLargeRadius(), 0.01);
   }
   
   /** 2nd test for editing ring toruses. **/
   @Test public void editRingTorusTest2() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      int num = torusList.length;
      RingTorusList torus = new RingTorusList("exp", torusList, num);
      double lRad = 148.72;
      double sRad = 35.87;
      Assert.assertFalse(torus.editRingTorus("no exp", lRad, sRad));
   }
   
   /** 1st test for finding ring toruses with the largest volume. **/
   @Test public void findRingTorusWithLargestVolumeTest1() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      RingTorusList torus = new RingTorusList("exp3", torusList, 1);
      Assert.assertEquals(ex1, torus.findRingTorusWithLargestVolume());
   }
   
   /** 2nd test for finding ring toruses with the largest volume. **/
   @Test public void findRingTorusWithLargestVolumeTest2() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      RingTorusList torus = new RingTorusList("exp3", torusList, 3);
      Assert.assertEquals(ex3, torus.findRingTorusWithLargestVolume());
   }
   
   /** 3rd test for finding ring toruses with the largest volume. **/
   @Test public void findRingTorusWithLargestVolumeTest3() {
      RingTorus ex1 = new RingTorus("ex1", 9.5, 1.25);
      RingTorus ex2 = new RingTorus("ex2", 35.1, 10.4);
      RingTorus ex3 = new RingTorus("ex3", 134.28, 32.46); 
      RingTorus[] torusList = {ex1, ex2, ex3};
      RingTorusList torus = new RingTorusList("exp3", torusList, 0);
      Assert.assertEquals(null, torus.findRingTorusWithLargestVolume());
   }   
  
}
