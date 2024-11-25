import java.util.Comparator;

/**
 * Compares info about prices in a baked item list.
 * @author - Thomas Eden
 * @version - November 11, 2022
 */

public class PriceComparator implements Comparator<BakedItem> {

/**
 * Compares baked item prices between BakedItem b1 and b2.
 * @param b1 as object 1 BakedItem
 * @param b2 as object 2 BakedItem
 * @return positive, negative, or equal to 0
 *    based on the price of each baked item.
 */

   public int compare(BakedItem b1, BakedItem b2) {
      if (b1.price() < b2.price()) {
         return -1;
      }
      else if (b1.price() > b2.price()) {
         return 1;
      }
      else {
         return 0;
      }
   }

}