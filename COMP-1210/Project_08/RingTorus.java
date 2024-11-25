import java.text.DecimalFormat;

/**
 * Represents info about ring torus.
 * @author - Thomas Eden
 * @version - October 21, 2022
 */

public class RingTorus implements Comparable<RingTorus> {

   private String label = "";
   private double largeRadius = 0;
   private double smallRadius = 0;
   private static int count = 0;
   
   /**
    * Constructor sets label, largeRadius, and smallRadius;
    * increments count.
    * @param labelIn for label
    * @param largeRadiusIn for largeRadius
    * @param smallRadiusIn for smallRadius
    */

   public RingTorus(String labelIn, double largeRadiusIn,
                  double smallRadiusIn) {
      setLabel(labelIn);
      setLargeRadius(largeRadiusIn);
      setSmallRadius(smallRadiusIn);
      count++;
   
   }
   
   /**
    * Gets label for ring torus.
    * @return label
    */
   
   public String getLabel() {
      return label; 
   }
   
   /**
    * Sets label for ring torus.
    * @param labelIn - label
    * @return labelIn.trim() if true, and null if false
    */
   
   public boolean setLabel(String labelIn) {
      if (labelIn == null) {
         return false;
      } else {
         label = labelIn.trim();
         return true; 
      }     
   } 
   
   /**
    * Gets large radius for ring torus.
    * @return largeRadius
    */ 
   
   public double getLargeRadius() {
      return largeRadius;
   } 
   
   /**
    * Sets large radius for ring torus.
    * @param largeRadiusIn - largeRadius
    * @return largeRadiusIn (set) as true
    */
   
   public boolean setLargeRadius(double largeRadiusIn) {
      boolean set = false;
      if (largeRadiusIn > 0 && largeRadiusIn > smallRadius) {
         largeRadius = largeRadiusIn;
         set = true;
      }
      return set;  
   }
   
   /**
    * Gets small radius for ring torus.
    * @return smallRadius
    */
   
   public double getSmallRadius() {
      return smallRadius;
   }
   
   /**
    * Sets small radius for ring torus.
    * @param smallRadiusIn - smallRadius
    * @return smallRadiusIn (set) as true
    */
   
   public boolean setSmallRadius(double smallRadiusIn) {
      boolean set = false;
      if (smallRadiusIn > 0 && smallRadiusIn < largeRadius) {
         smallRadius = smallRadiusIn;
         set = true;
      }
      return set;
   }
   
   /**
    * Calculates diameter for ring torus.
    * @return output for diameter
    */
   
   public double diameter() {
      return 2 * (largeRadius + smallRadius);
   }
   
   /**
    * Calculates surface area for ring torus.
    * @return output for surface area
    */
   
   public double surfaceArea() {
      return (2 * Math.PI * largeRadius) * (2 * Math.PI * smallRadius);
   }
   
   /**
    * Calculates volume for ring torus.
    * @return output for volume
    */
   
   public double volume() {
      return (2 * Math.PI * largeRadius) * (Math.PI * Math.pow(smallRadius, 2));
   }
   
   /**
    * Calculates RingTorus and returns
    * a String representation of the ring torus.
    * @return inputs as String.
    */
   
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      return ("RingTorus " + "\"" + label + "\""
            + "\n\tlarge radius = " + df.format(largeRadius) + " units"
            + "\n\tsmall radius = " + df.format(smallRadius) + " units"
            + "\n\tdiameter = " + df.format(diameter()) + " units"
            + "\n\tsurface area = " + df.format(surfaceArea()) + " square units"
            + "\n\tvolume = " + df.format(volume()) + " cubic units");
   }
   
   /**
    * Gets static count of ring toruses created.
    * @return count
    */
   
   public static int getCount() {
      return count; 
   } 
   
   /**
    * Resets count to zero.
    *
    */  
   
   public static void resetCount() {
      count = 0;
   }
   
   /**
    * Accept parameters of Object obj and uses boolean
    * to determine if it is or isn't a ring torus.
    * @param obj for Object
    * @return false if not a ring torus, true if it is a ring torus
    */
   
   public boolean equals(Object obj) {
      if (!(obj instanceof RingTorus)) {
         return false;
      } else {
         RingTorus rt = (RingTorus) obj; 
         return (label.equalsIgnoreCase(rt.getLabel())
                   && (Math.abs(largeRadius - rt.getLargeRadius()) < .000001)
                   && (Math.abs(smallRadius - rt.getSmallRadius()) < .000001));
      }
   }
   
   /**
    * Returns zero as an int.
    * @return 0
    */
   
   public int hashCode() {
      return 0;
   }
   
   /**
    * Accepts parameters of RingTorus obj and uses boolean
    * to determine ring torus values based on volume.
    * @param obj for RingTorus
    * @return -1 if (this.volume() < obj.volume()),
    *          1 if (this.volume() > obj.volume()),
    *          0 if (this.volume() == obj.volume())
    */
     
   public int compareTo(RingTorus obj) {
      if (this.volume() < obj.volume()) {
         return -1;
      } else if (this.volume() > obj.volume()) {
         return 1;
      } else {
         return 0;   
      }     
   }
}