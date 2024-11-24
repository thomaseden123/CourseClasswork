import java.util.Arrays;
import java.util.Comparator;

/**
 * Binary search.
 */
public class BinarySearch {

   /**
    * Returns the index of the first key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      int result = -1;
      if ((a == null) || (key == null) || (comparator == null)) {
         throw new NullPointerException();
      }
      else {
         for (int i = 0; i < a.length - 1; i++) {
            if (a[i] == key) {
               result = i;
               break;
            }
         }
         return result;
      }
   }

   /**
    * Returns the index of the last key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
      int index = -1;
      if ((a == null) || (key == null) || (comparator == null)) {
         throw new NullPointerException();
      }
      else {
         for (int i = a.length - 1; i > 0; i--) {
            if (a[i] == key) {
               index = i;
               break;
            }
         }
         return index;
      }
   }

}
