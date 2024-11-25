import java.util.ArrayList;

/** 
 * Represents a list of high and low temperatures.
 *
 * @author - Thomas Eden
 * @version - September 27, 2022
 */

public class Temperatures {
   private ArrayList<Integer> temperatures;
   
   /**
    * Create an object for Temperatures.
    * @param temperaturesIn - temperatures
    */

   public Temperatures(ArrayList<Integer> temperaturesIn) { 
      temperatures = temperaturesIn;
   }
   
   /**
    * Method for getting low temperature.
    * @return low
    */
   
   public int getLowTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      int low = temperatures.get(0);
      for (int i = 0; i < temperatures.size(); i++) {
         if (temperatures.get(i) < low) {
            low = temperatures.get(i);
         }
      }
      return low;
   }
   
   /**
    * Method for getting high temperature.
    * @return high
    */
   
   public int getHighTemp() {
      if (temperatures.isEmpty()) {
         return 0;
      }
      int high = temperatures.get(0);
      for (Integer temp : temperatures) {
         if (temp > high) {
            high = temp;
         }
      }
      return high;
   }
   
   /**
    * Method for toString.
    * @return String
    */
   
   public String toString() {
      return "\tTemperatures: " + temperatures
            + "\n\tLow: " + getLowTemp()
            + "\n\tHigh: " + getHighTemp();
   }
   
   /**
    * Method for getting minimum temperature.
    * @param lowIn - low
    * @return lowIn
    */         
   
   public int lowerMinimum(int lowIn) {
      return lowIn < getLowTemp() ? lowIn : getLowTemp();
   }
   
    /**
     * Method for getting maximum temperature.
     * @param highIn - high
     * @return highIn
     */
   
   public int higherMaximum(int highIn) {
      return highIn > getHighTemp() ? highIn : getHighTemp();
   }
            
}