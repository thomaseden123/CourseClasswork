import java.util.ArrayList;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.FileNotFoundException; 
import java.io.File;  

/** 
 * Represents a list of hexagonal prisms.
 *
 * @author - Thomas Eden
 * @version - September 23, 2022
 */

public class HexagonalPrismList {
   private String list = "";
   private ArrayList<HexagonalPrism> prismList 
      = new ArrayList<HexagonalPrism>();
      
   /** 
    * Create a HexagonalPrismList object. 
    * Constructor.
    * @param listIn for list
    * @param prismListIn for prismList
    */   
   
   public HexagonalPrismList(String listIn, 
      ArrayList<HexagonalPrism> prismListIn) {
   
      list = listIn;
      prismList = prismListIn;
      double totalSurfaceArea = 0;
      double totalVolume = 0;
      double averageSurfaceArea = 0;
      double averageVolume = 0;
   
   }
   
   /** 
    * Gets the name of the list.
    * @return list
    */
   
   public String getName() {
      return list;
   }
   
   /**
    * Prints number of hexagonal prisms. 
    * @return the number of HexagonalPrism objects in prismList.
    */
   
   public int numberOfHexagonalPrisms() {
      if (prismList.size() == 0) {
         return 0;
         
      } else {
         return prismList.size();    
      }    
   }
   
   /** 
    * Calculates total surface area.
    * @return the total Surface Area
    */
   
   public double totalSurfaceArea() {
      double output = 0;
      int index = 0;
      while (index < prismList.size()) {
         HexagonalPrism hexPrism = prismList.get(index);
         output += hexPrism.surfaceArea();
         index++;
      }
      return output;
   }
   
   /**
    * Calculates total volume. 
    * @return the total Volume
    */
   
   public double totalVolume() {
      double output = 0;
      int index = 0;
      while (index < prismList.size()) {
         HexagonalPrism hexPrism = prismList.get(index);
         output += hexPrism.volume();
         index++;
      }
      return output;
   }
   
   /**
    * Calculates average surface area. 
    * @return the average Surface Area
    */
   
   public double averageSurfaceArea() {
      double output = 0;
      int index = 0;
      while (index < prismList.size()) {
         HexagonalPrism hexPrism = prismList.get(index);
         output = totalSurfaceArea() / prismList.size();
         index++;
      }
      return output;
   }
   
   /** 
    * Calculates average volume.
    * @return the average Volume
    */
   
   public double averageVolume() {
      double output = 0;
      int index = 0;
      while (index < prismList.size()) {
         HexagonalPrism hexPrism = prismList.get(index);
         output = totalVolume() / prismList.size();
         index++;
      }
      return output;
   }
   
   /**
    * Calculates HexagonalPrismList. 
    * @return String representation of HexagonalPrismList.
    */
   
   public String toString() {
      String output = "----- " + getName() + " -----\n";
      int index = 0;
      while (index < prismList.size()) {
         HexagonalPrism hexPrism = prismList.get(index);
         output += "\n" + hexPrism.toString() + "\n";
         index++;
      }
      return output;     
   }
   
   /**
    * Gives summary info of list. 
    * @return String for summary info of the list 
    * (includes name of list and results for various method calls)
    */
   
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.0##");
      return ("----- Summary for " + getName() + " -----"
            + "\nNumber of HexagonalPrisms: " + prismList.size()
            + "\nTotal Surface Area: " + df.format(totalSurfaceArea()) 
            + " square units"
            + "\nTotal Volume: " + df.format(totalVolume()) + " cubic units"
            + "\nAverage Surface Area: " + df.format(averageSurfaceArea()) 
            + " square units"
            + "\nAverage Volume: " + df.format(averageVolume()) 
            + " cubic units");
   
   }
   
  /** 
   * Project 6.
   * Represents a continued list of hexagonal prisms.
   * Adds 6 more methods.
   * @author - Thomas Eden
   * @version - October 2, 2022
   */
   
   //************************************************************
   //******************** Begin new methods *********************
   //************************************************************
   
  /**
   * Gets a list of hexagonal prisms.
   * @return prismList
   */
   
   public ArrayList<HexagonalPrism> getList() {
      return prismList;
   }
   
  /**  
   * Reads in hexagonal prism data from file and creates a 
   * HexagonalPrismList object.
   *
   * @param fileNameIn - fileName
   * @return HexagonalPrismList
   * @throws FileNotFoundException if the file cannot be opened.
   */
   
   public HexagonalPrismList readFile(String fileNameIn)
                                       throws FileNotFoundException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      ArrayList<HexagonalPrism> myPrismList = new ArrayList<HexagonalPrism>();
      String label = "";
      double edge = 0;
      double height = 0;    
      list = scanFile.nextLine();
    
      while (scanFile.hasNext()) {
         label = scanFile.nextLine();
         edge = Double.parseDouble(scanFile.nextLine());
         height = Double.parseDouble(scanFile.nextLine());
         HexagonalPrism hp = new HexagonalPrism(label, edge, height);
         prismList.add(hp);
      }                                
   
      HexagonalPrismList hexPrismList
                   = new HexagonalPrismList(list, prismList);    
      return hexPrismList;   
   }
   
   /**
    * Adds HexagonalPrism to list.
    * @param labelIn - label
    * @param edgeIn - edge
    * @param heightIn - height
    */
   
   public void addHexagonalPrism(String labelIn, 
                        double edgeIn, double heightIn) {
      HexagonalPrism hpList = new HexagonalPrism(labelIn, edgeIn, heightIn);
      prismList.add(hpList);
   }
   
   /**
    * Finds HexagonalPrism on list.
    * @param labelIn - label
    * @return index if true, and null if false
    */
   
   public HexagonalPrism findHexagonalPrism(String labelIn) {
      for (HexagonalPrism hpList : prismList) {
         if (hpList.getLabel().equalsIgnoreCase(labelIn)) {
            return prismList.get(prismList.indexOf(hpList));
         }   
      }   
      return null;   
   }
   
   /**
    * Deletes HexagonalPrism from list.
    * @param labelIn - label
    * @return index if true, and null if false
    */
   
   public HexagonalPrism deleteHexagonalPrism(String labelIn) {
      for (HexagonalPrism hpList : prismList) {
         if (hpList.getLabel().equalsIgnoreCase(labelIn)) {
            return prismList.remove(prismList.indexOf(hpList));
         }   
      }  
      return null;
   }
   
   /**
    * Edits HexagonalPrism on list.
    * @param labelIn - label
    * @param edgeIn - edge
    * @param heightIn - height
    * @return true if edited, false if not
    */
   
   public boolean editHexagonalPrism(String labelIn, 
                              double edgeIn, double heightIn) {
      for (int i = 0; i < prismList.size(); i++) {
         if (prismList.get(i).getLabel().equalsIgnoreCase(labelIn)) {
            prismList.get(i).setEdge(edgeIn);
            prismList.get(i).setHeight(heightIn);
            return true;
         }
       
      }
      return false;
   }
    
}