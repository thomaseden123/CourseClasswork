import java.text.DecimalFormat;

/**
 * Represents a hexagonal prism and provides a classification
 * of the hexagonal prism's label, edge, and height.
 * @author - Thomas Eden
 * @version - September 13, 2022
 */

public class HexagonalPrism {

   private String label;
   private double edge;
   private double height;
   
   /**
    * Initializes a HexagonalPrism object given its
    * label, edge, and height.
    * @param labelIn for label.
    * @param edgeIn for edge.
    * @param heightIn for height.
    *
    */

   public HexagonalPrism(String labelIn, double edgeIn, double heightIn) {
   
      setLabel(labelIn.trim());
      setEdge(edgeIn);
      setHeight(heightIn);
      double surfaceArea = 0;
      double lateralSurfaceArea = 0;
      double baseArea = 0;
      double volume = 0;
   
   }
   
   /**
    * Gets label of HexagonalPrism.
    * @return label of HexagonalPrism as String.
    */
   
   public String getLabel() {
      return label;
   }
   
   /**
    * Sets label of HexagonalPrism.
    * @param labelIn - label.
    * @return as true.
    */
   
   public boolean setLabel(String labelIn) {
      if (labelIn != null && labelIn.length() > 0) {
         label = labelIn.trim();
         return true;
      }   
      return false;
   } 
    
   /**
    * Gets edge of HexagonalPrism.
    * @return edge of HexagonalPrism as double.
    */
   
   public double getEdge() {
      return edge;
   }
   
   /**
    * Sets edge.
    * @param edgeIn - edge.
    * @return isSet2 as double.
    */
   
   public boolean setEdge(double edgeIn) { 
      boolean isSet2 = false;
      if (edgeIn > 0) {
         edge = edgeIn;
         isSet2 = true;
      }
      return isSet2;
   }
   
   /**
    * Gets height.
    * @return height as double.
    */
      
   public double getHeight() {
      return height;
   } 
   
   /**
    * Sets height.
    * @param heightIn - height.
    * @return isSet3 as double.
    */
   
   public boolean setHeight(double heightIn) { 
      boolean isSet3 = false;
      if (heightIn > 0) {
         height = heightIn;
         isSet3 = true;
      }
      return isSet3;
   }
   
   /**
    * Returns surface area of the hexagonal prism. 
	 * @return surface area of hexagonal prism as a double
    */
   
   public double surfaceArea() {
      return ((6 * edge * height) + (3 * Math.sqrt(3) * Math.pow(edge, 2)));
   }
   
   /**
    * Returns lateral surface area of the hexagonal prism. 
	 * @return lateral surface area of hexagonal prism as a double
    */
      
   public double lateralSurfaceArea() {
      return ((6 * edge * height)); 
   }
   
   /**
    * Returns base area of the hexagonal prism. 
	 * @return base area of hexagonal prism as a double
    */
   
   public double baseArea() {
      return ((3 * Math.sqrt(3) * Math.pow(edge, 2) / 2));
   }
   
   /**
    * Returns volume of the hexagonal prism. 
	 * @return volume of hexagonal prism as a double
    */
   
   public double volume() {
      return ((3 * Math.sqrt(3) / 2) * (Math.pow(edge, 2)) * height);
   } 
   
   /**
    * Calculates HexagonalPrism and
    * returns a String representation of the hexagonal prism.
    * @return inputs as String.
    */
   
   
   public String toString() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      return ("HexagonalPrism " + "\"" + label + "\"" + " has 8 faces, "
            + "18 edges, and 12 vertices."
            + "\n\tedge = " + df.format(edge) + " units"
            + "\n\theight = " + df.format(height) + " units"
            + "\n\tlateral surface area = " + df.format(lateralSurfaceArea()) 
            + " square units"
            + "\n\tbase area = " + df.format(baseArea()) + " square units"
            + "\n\tsurface area = " + df.format(surfaceArea()) + " square units"
            + "\n\tvolume = " + df.format(volume()) + " cubic units");
            
   }        
}