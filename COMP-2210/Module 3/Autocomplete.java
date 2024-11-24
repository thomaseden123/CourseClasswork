import java.util.Arrays;


/**
 * Autocomplete.
 */
public class Autocomplete {

   private Term[] terms;

	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
   public Autocomplete(Term[] terms) {
      if (terms == null) {
         throw new java.lang.NullPointerException(); 
      }    
      Arrays.sort(terms);
   }

	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
	 */
   public Term[] allMatches(String prefix) {
      if (prefix == null) { 
         throw new NullPointerException();
      }
      int index1 = BinarySearch.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
      if (index1 == -1) {
         return new Term[0];
      }    
      int index2  = BinarySearch.lastIndexOf (terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
      Term[] matched = new Term[index2 - index1 + 1];
      
      for (int i = 0; i < matched.length; i++) {
         matched[i] = terms[index1++];
      }
      Arrays.sort(matched, Term.byDescendingWeightOrder());
      
      return matched;
   }

}

