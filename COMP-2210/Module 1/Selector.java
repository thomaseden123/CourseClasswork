import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Thomas Eden (tae0017@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  01/29/23
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int min(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      } 
      int min = a[0];
      for (int i = 0; i < a.length; i++) {
         if (a[i] <= min) {
            min = a[i];
         }   
      }
      return min;  
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    */
   public static int max(int[] a) {
      if (a == null || a.length == 0) {
         throw new IllegalArgumentException();
      }
      int max = a[0];
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= max) {
            max = a[i];
         }   
      }
      return max;   
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmin(int[] a, int k) {
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      int[] sorted = Arrays.copyOf(a, a.length);
      int x = 0;
      Arrays.sort(sorted);
      for (int i = 1; i < sorted.length; i++) {
         if (sorted[i] == sorted[i - 1]) {
            x++;
         }
      }
      int y = k - 1;
      return sorted[y];
   }


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    */
   public static int kmax(int[] a, int k) {
      if (a == null || a.length == 0 || k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      int[] sorted = Arrays.copyOf(a, a.length);
      int x = 0;
      Arrays.sort(sorted);
      for (int i = 1; i < sorted.length; i++) {
         if (sorted[i] == sorted[i - 1]) {
            x++;
         }
      }
      int y = sorted.length - k;
      return sorted[y];
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    */
   public static int[] range(int[] a, int low, int high) {
      if ((a == null) || (a.length == 0)) {
         throw new IllegalArgumentException();
      }
      int x = 0;
      for (int i = 0; i < a.length; i++) {
         if (low <= a[i] && a[i] <= high) {
            x++;
         }
      }
      int[] y = new int[x];
      int z = 0;
      for (int i = 0; i < a.length; i++) {
         if (low <= a[i] && a[i] <= high) {
            y[z] = a[i];
            z++;
         }
      }
      return y;      
   }  


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int ceiling(int[] a, int key) {
      int m = 10;
      if (a == null) {
         throw new IllegalArgumentException("Null array");
      }
      else if (a.length == 0) {
         throw new IllegalArgumentException("Empty array");
      }
      else {
         for (int i = 0; i < a.length; i++) {
            if (0 <= (a[i] - key) && (a[i] - key) <= (m - key)) {
               m = a[i];
            }
         }
      }
      if (m == 10) {
         throw new IllegalArgumentException("No array values");
      }
      return m;
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    */
   public static int floor(int[] a, int key) {
      int m = -10;
      if (a == null) {
         throw new IllegalArgumentException("Null array");
      }
      else if (a.length == 0) {
         throw new IllegalArgumentException("Empty array");
      }
      else {
         for (int i = 0; i < a.length; i++) {
            if (0 <= (key - a[i]) && (key - a[i]) <= (key - m)) {
               m = a[i];
            }
         }
      }
      if (m == -10) {
         throw new IllegalArgumentException("No array values");
      }
      return m;
   }   
}
