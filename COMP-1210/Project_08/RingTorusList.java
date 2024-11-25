import java.text.DecimalFormat;

/**
 * Represents a list info about ring torus.
 * @author - Thomas Eden
 * @version - October 29, 2022
 */

public class RingTorusList {

   private String list = "";
   private RingTorus[] torusArray;
   private int number = 0;
   
   /**
    * Constructor.
    * @param listIn for list
    * @param torusArrayIn for torusArray
    * @param numberIn for number
    */

   public RingTorusList(String listIn, 
                     RingTorus[] torusArrayIn, int numberIn) {
      list = listIn;
      torusArray = torusArrayIn;
      number = numberIn;                    
   }
   
    /**
     * Gets name.
     * @return list
     */
   
   public String getName() {
      return list;   
   }
   
    /**
     * Gets number of ring toruses.
     * @return number
     */
   
   public int numberOfRingToruses() {
      return number;
   }
   
   /**
    * Calculates the total diameter using a while loop.
    * @return the total torus diameter in this RingTorusList object;
    * return 0 if list is empty.
    */
   
   public double totalDiameter() {
      double output = 0;
      int index = 0;
      while (index < number) {
         RingTorus torus = torusArray[index];
         output += torus.diameter();
         index++;
      }
      return output;
   }
   
   /**
    * Calculates the total surface area using a while loop.
    * @return the total torus surface area in this RingTorusList object;
    * return 0 if list is empty.
    */
    
   public double totalSurfaceArea() {
      double output = 0;
      int index = 0;
      while (index < number) {
         RingTorus torus = torusArray[index];
         output += torus.surfaceArea();
         index++;
      }
      return output;
   }
   
   /**
    * Calculates the total volume using a while loop.
    * @return the total torus volume in this RingTorusList object;
    * return 0 if list is empty.
    */
   
   public double totalVolume() {
      double output = 0;
      int index = 0;
      while (index < number) {
         RingTorus torus = torusArray[index];
         output += torus.volume();
         index++;
      }
      return output;
   }
   
   /**
    * Calculates the average diameter using a while loop.
    * @return the average diameter in this RingTorusList object;
    * return 0 if list is empty.
    */
   
   public double averageDiameter() {
      double output = 0;
      int index = 0;
      while (index < number) {
         RingTorus torus = torusArray[index];
         output += torus.diameter() / number;
         index++;
      }
      return output;
   }

   /**
    * Calculates the average surface area using a while loop.
    * @return the average surface area in this RingTorusList object;
    * return 0 if list is empty.
    */
   
   public double averageSurfaceArea() {
      double output = 0;
      int index = 0;
      while (index < number) {
         RingTorus torus = torusArray[index];
         output += torus.surfaceArea() / number;
         index++;
      }
      return output;
   }
   
   /**
    * Calculates the average volume using a while loop.
    * @return the average volume in this RingTorusList object;
    * return 0 if list is empty.
    */
   
   public double averageVolume() {
      double output = 0;
      int index = 0;
      while (index < number) {
         RingTorus torus = torusArray[index];
         output += torus.volume() / number;
         index++;
      }
      return output;
   }
   
   /**
    * Gives summary of ring toruses.
    * @return the String representation of the RingTorusList
    */
   
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      return ("----- Summary for " + getName() + " -----"
            + "\nNumber of RingToruses: " + torusArray.length
            + "\nTotal Diameter: " + df.format(totalDiameter()) 
            + " units"
            + "\nTotal Surface Area: " + df.format(totalSurfaceArea()) 
            + " square units"
            + "\nTotal Volume: " + df.format(totalVolume()) + " cubic units"
            + "\nAverage Diameter: " + df.format(averageDiameter()) 
            + " units"
            + "\nAverage Surface Area: " + df.format(averageSurfaceArea()) 
            + " square units"
            + "\nAverage Volume: " + df.format(averageVolume()) 
            + " cubic units");
   }
   
    /**
     * Gets list of ring toruses.
     * @return torusArray
     */
   
   public RingTorus[] getList() {
      return torusArray;
   }
   
   /**
    * Adds a RingTorus object to the list.
    * @param labelIn - label
    * @param largeRadiusIn - largeRadius
    * @param smallRadiusIn - smallRadius
    */
   
   public void addRingTorus(String labelIn, 
                        double largeRadiusIn, double smallRadiusIn) {
      RingTorus tList = new RingTorus(labelIn, largeRadiusIn, smallRadiusIn);
      torusArray[number] = tList;                        
      number++;
   }
   
   /**
    * Finds a RingTorus on the list.
    * @param labelIn - label
    * @return torusArray[i] if true, and null if false
    */
   
   public RingTorus findRingTorus(String labelIn) {
      for (int i = 0; i < number; i++) {
         if (torusArray[i].getLabel().equalsIgnoreCase(labelIn)) {
            return torusArray[i];
         } 
      }
      return null;     
   }
   
   /**
    * Deletes a RingTorus on the list.
    * @param labelIn - label
    * @return torusArray[i] if true, and null if false
    */
    
   public RingTorus deleteRingTorus(String labelIn) {
      for (int i = 0; i < number; i++) {
         if (torusArray[i].getLabel().equalsIgnoreCase(labelIn)) {
            for (int x = i; x < number - 1; x++) {
               torusArray[x] = torusArray[x + 1];  
            }
            torusArray[number - 1] = null;
            number--;
            return torusArray[i];
            
         }   
      }   
      return null;   
   }
   
   /**
    * Edits RingTorus on list.
    * @param labelIn - label
    * @param largeRadiusIn - largeRadius
    * @param smallRadiusIn - smallRadius
    * @return torusArray[i] as true if edited, false if not
    */
   
   public boolean editRingTorus(String labelIn, 
                           double largeRadiusIn, double smallRadiusIn) {
      for (int i = 0; i < number; i++) {
         if (torusArray[i].getLabel().equalsIgnoreCase(labelIn)) {
            torusArray[i].setLargeRadius(largeRadiusIn);
            torusArray[i].setSmallRadius(smallRadiusIn);
            return true;
         }
       
      }
      return false;
   }
   
   /**
    * Finds the RingTorus with the largest volume.
    * @return torusArray[num] if true, and null if false
    */
   
   public RingTorus findRingTorusWithLargestVolume() {
      int num = 0;
      double lV = 0;
      if (number > 0) {
         for (int i = 0; i < number; i++) {
            if (torusArray[i].volume() > lV) {
               lV = torusArray[i].volume();
               num = i;
            }
         } 
         return torusArray[num];
      }
      return null;
   }
}