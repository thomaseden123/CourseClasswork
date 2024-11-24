import java.util.Comparator;

/**
 * Autocomplete term representing a (query, weight) pair.
 * 
 */
public class Term implements Comparable<Term> {

   private String query;
   private double weight = 0;

   /**
    * Initialize a term with the given query and weight.
    * This method throws a NullPointerException if query is null,
    * and an IllegalArgumentException if weight is negative.
    */
   public Term(String query, long weight) {
      if (query == null) {
         throw new NullPointerException();
      }
      else if (weight < 0) {
         throw new IllegalArgumentException();
      }
      else {
         this.query = query;
         this.weight = weight;
      }
   }

   /**
    * Compares the two terms in descending order of weight.
    */
   public static Comparator<Term> byDescendingWeightOrder() {
      return new ByReverseWeightOrder();
   }

   /**
    * Compares the two terms in ascending lexicographic order of query,
    * but using only the first length characters of query. This method
    * throws an IllegalArgumentException if length is less than or equal
    * to zero.
    */
   public static Comparator<Term> byPrefixOrder(int length) {
      if (length <= 0) {
         throw new IllegalArgumentException("Length is 0 or less.");
      }
      else {
         return new ByPrefixOrder(length);
      }
   }

   /**
    * Compares this term with the other term in ascending lexicographic order
    * of query.
    */
   @Override
   public int compareTo(Term other) {
      int c = this.query.compareTo(other.query);
      return c;
   }
 
   public static class ByPrefixOrder implements Comparator<Term> {
      private int w;
   
      public ByPrefixOrder(int w){
         this.w = w;
      }
   
      @Override
        public int compare(Term t1, Term t2){
         int p = t1.query.length() < w ? t1.query.length() : w;
         int d = t2.query.length() < w ? t2.query.length() : w;
         return t1.query.substring(0, p).compareTo(t2.query.substring(0, d));
      }
   }
     
   public static class ByReverseWeightOrder implements Comparator<Term> {
      @Override
      public int compare(Term t, Term t1){
         return (int) (t1.weight - t.weight);
      }
   }

   /**
    * Returns a string representation of this term in the following format:
    * query followed by a tab followed by weight
    */
   @Override
   public String toString(){
      return this.query + "\t" + (int)this.weight;
   }

}

