import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException; 
import java.io.File;

/**
 * Represents info about a baked item list.
 * @author - Thomas Eden
 * @version - November 18, 2022
 */

public class BakedItemList {
   private String listName;
   private BakedItem[] itemList;
   private int itemCount;
   private String[] excludedRecords;
   private int excludedCount;
   private static int listCount = 0;
   
   /**
    * BakedItemList constructor that has no parameters
    * and initializes the instance variables of listName, itemList,
    * itemCount, excludedRecords, and excludedCount.
    */

   public BakedItemList() {
   
      listName = "";
      itemList = new BakedItem[100];
      itemCount = 0;
      excludedRecords = new String[30];
      excludedCount = 0;
      listCount++;
   
   }
   
   /**
    * Getter for the baked item list name.
    * @return list name of baked item
    */
   
   public String getListName() {
      return listName;
   }
   
   /**
    * Setter for the baked item list name 
    * and returns nothing.
    * @param listNameIn initializes listName variable in BakedItemList
    */
   
   public void setListName(String listNameIn) {
      listName = listNameIn;
   }
   
   /**
    * Getter for the baked item list.
    * @return list of baked items
    */
   
   public BakedItem[] getItemList() {
      return itemList;
   }
   
   /**
    * Setter for the baked item list
    * and returns nothing.
    * @param itemListIn initializes itemList variable in BakedItemList
    */
   
   public void setItemList(BakedItem...itemListIn) {
      itemList = itemListIn;
   }
   
   /**
    * Getter for the baked item count.
    * @return count of baked items
    */
   
   public int getItemCount() {
      return itemCount;
   }
   
   /**
    * Setter for the baked item count
    * and returns nothing.
    * @param itemCountIn initializes itemCount variable in BakedItemList
    */
   
   public void setItemCount(int itemCountIn) {
      itemCount = itemCountIn;
   }
   
   /**
    * Getter for the excluded records.
    * @return excluded records
    */
   
   public String[] getExcludedRecords() {
      return excludedRecords;
   }
   
   /**
    * Setter for the excluded records
    * and returns nothing.
    * @param excludedRecordsIn initializes excludedRecords variable
    * in BakedItemList
    */
   
   public void setExcludedRecords(String...excludedRecordsIn) {
      excludedRecords = excludedRecordsIn;
   }
   
   /**
    * Getter for the excluded count.
    * @return excluded count
    */
   
   public int getExcludedCount() {
      return excludedCount;
   }
   
   /**
    * Setter for the excluded count
    * and returns nothing.
    * @param excludedCountIn initializes excludedCount variable in BakedItemList
    */
   
   public void setExcludedCount(int excludedCountIn) {
      excludedCount = excludedCountIn;
   }
   
   /**
    * Gets static count of baked item lists created.
    * @return listCount
    */
   
   public static int getListCount() {
      return listCount;
   }
   
   /**
    * Resets list count to zero and returns nothing.
    */
   
   public static void resetListCount() {
      listCount = 0;
   }
   
   /**  
   * Has no return value and accepts the data file name as a String.  
   * This method creates a Scanner object to read in the file, and then
   * reads the file line by line. The first line contains the BakedItemList name
   * and each of the remaining lines contains the data for a baked item.
   * @param fileNameIn initializes the fileName variable in BakedItemList
   * @throws FileNotFoundException if the file cannot be opened.
   */
   
   public void readItemFile(String fileNameIn)
                                      throws FileNotFoundException {
      Scanner scanFile = new Scanner(new File(fileNameIn));
      listName = scanFile.nextLine();
      String line = "";
      char category;
      String name = "";
      String flavor = "";
      int quantity = 0;
      String[] ingredients;
      int layers = 0;
      int tiers = 0;
      double crustCost = 0;
      while (scanFile.hasNext()) {
         line = scanFile.nextLine();
         Scanner lineScan = new Scanner(line);
         lineScan.useDelimiter(",");
         category = lineScan.next().toUpperCase().charAt(0);
         int array = 0;
         try {
            if (category == 'C') {
               name = lineScan.next();
               flavor = lineScan.next();
               quantity = Integer.parseInt(lineScan.next());
               ingredients = new String[50]; 
               while (lineScan.hasNext()) {
                  ingredients[array] = lineScan.next();
                  array++;
               }
               String[] obj = Arrays.copyOf(ingredients, array);
               Cookie c = new Cookie(name, flavor, quantity, obj);
               itemList[itemCount] = c;
               itemCount++;
             
            } else if (category == 'P') {
               name = lineScan.next();
               flavor = lineScan.next();
               quantity = Integer.parseInt(lineScan.next());
               crustCost = Double.parseDouble(lineScan.next());
               ingredients = new String[50]; 
               while (lineScan.hasNext()) {
                  ingredients[array] = lineScan.next();
                  array++;
               }
               String[] obj = Arrays.copyOf(ingredients, array);
               Pie p = new Pie(name, flavor, quantity, crustCost, obj);
               itemList[itemCount] = p;
               itemCount++;
            
            } else if (category == 'K') { 
               name = lineScan.next();
               flavor = lineScan.next();
               quantity = Integer.parseInt(lineScan.next());
               layers = Integer.parseInt(lineScan.next());
               ingredients = new String[50];      
               while (lineScan.hasNext()) {
                  ingredients[array] = lineScan.next();
                  array++;
               }
               String[] obj = Arrays.copyOf(ingredients, array);
               Cake k = new Cake(name, flavor, quantity, layers, obj);
               itemList[itemCount] = k;
               itemCount++;
            
            } else if (category == 'W') {  
               name = lineScan.next();
               flavor = lineScan.next();
               quantity = Integer.parseInt(lineScan.next());
               layers = Integer.parseInt(lineScan.next());
               tiers = Integer.parseInt(lineScan.next());
               ingredients = new String[50];      
               while (lineScan.hasNext()) {
                  ingredients[array] = lineScan.next();
                  array++;
               }
               String[] obj = Arrays.copyOf(ingredients, array);
               WeddingCake w = new WeddingCake(name, flavor, quantity, layers, 
                                    tiers, obj);
               itemList[itemCount] = w;
               itemCount++;
            } else {
               throw new InvalidCategoryException(Character.toString(category));
            }
         }
             // If the line of data begins with an invalid category, 
             // the program should throw an InvalidCategoryException.
         catch (InvalidCategoryException e) { 
                
            excludedRecords[excludedCount] =
                  "*** " + e + " in:\n" + line; 
            excludedCount++;           
         } 
            // If the line of data has a valid category, 
            // but includes invalid numeric data, a NumberFormatException
            // will be thrown automatically by the
            // Java Runtime Environment (JRE). 
         catch (NumberFormatException e) { 
                
            excludedRecords[excludedCount] = 
                  "*** " + e + " in:\n" + line; 
            excludedCount++;             
         }
            // If the line of data has a valid category but has missing data,
            // a java.util.NoSuchElementException will be
            // thrown automatically by the JRE. 
         catch (java.util.NoSuchElementException e) { 
                
            excludedRecords[excludedCount] = 
                  "*** " + e + " in:\n" + line; 
            excludedCount++;             
         }
      }
           
      
   }
   
   /**
    * Processes the item list array using the original order  
    * from the file to produce the bakery report. 
    * @return output of each baked item as String
    */
   
   public String generateReport() {
      String output = "\n---------------------------------------\nReport for "
             + getListName() + "\n---------------------------------------\n";
      for (int i = 0; i < itemList.length; i++) {
         if (itemList[i] != null) {
            output += "\n" + itemList[i].toString() + "\n";
         }
      }
      return output;      
   }
   
   /**
    * Generates a bakery report of each baked item based on
    * each item's class (name) from A to Z. 
    * @return output of each baked item by class as String
    */
         
   public String generateReportByClass() {
      BakedItem[] classList = Arrays.copyOf(itemList, itemCount);
      Arrays.sort(classList);
      String output = "\n---------------------------------------\nReport for "
                  + getListName() + " (by Class)"
                  + "\n---------------------------------------\n";
      for (int i = 0; i < classList.length; i++) {
         if (classList[i] != null) {
            output += "\n" + classList[i].toString() + "\n";
         }   
      }
      return output;      
         
   }
   
   /**
    * Generates a bakery report of each baked item based on
    * each item's price from lowest to highest. 
    * @return output of each baked item by price as String
    */
   
   public String generateReportByPrice() {
      BakedItem[] priceList = Arrays.copyOf(itemList, itemCount);
      Arrays.sort(priceList, new PriceComparator());
      String output = "\n---------------------------------------\nReport for "
                  + getListName() + " (by Price)"
                  + "\n---------------------------------------\n";
      for (int i = 0; i < priceList.length; i++) {
         if (priceList[i] != null) {
            output += "\n" + priceList[i].toString() + "\n";
         }
      }
      return output;            
                  
   }
   
   /**
    * Generates a bakery report of each baked item based on
    * each item's flavor from A to Z. 
    * @return output of each baked item by flavor as String
    */
   
   public String generateReportByFlavor() {
      BakedItem[] flavorList = Arrays.copyOf(itemList, itemCount);
      Arrays.sort(flavorList, new FlavorComparator());
      String output = "\n---------------------------------------\nReport for "
                  + getListName() + " (by Flavor)"
                  + "\n---------------------------------------\n";
      for (int i = 0; i < flavorList.length; i++) {
         if (flavorList[i] != null) {
            output += "\n" + flavorList[i].toString() + "\n";
         }
      }
      return output;            
                  
   }
   
   /**
    * Processes the excludedRecords array to 
    * produce the Excluded Records Report.
    * @return output of each baked item's 
    * excluded records as String
    */
   
   public String generateExcludedRecordsReport() {
      String output = "\n---------------------------------------\n"
                  + "Excluded Records Report"
                  + "\n---------------------------------------\n";
      for (int i = 0; i < excludedCount; i++) {
         if (excludedRecords[i] != null) { 
            output += "\n" + excludedRecords[i];
         }
      }
      return output;            
                  
   }
   
}