   /**
 * Represents info for online articles.
 * @author - Thomas Eden
 * @version - November 1, 2022
 */ 

public class OnlineArticle extends OnlineTextItem {
   private int wordCount = 0;
   
   /**
    * Set up constructor for OnlineArticle.
    * @param nameIn - name
    * @param priceIn - price
    */
   
   public OnlineArticle(String nameIn, double priceIn) {
      super(nameIn, priceIn);
   }
   
   /**
    * Sets the word count of the book.
    * @param wordCountIn - wordCount
    */
   
   
   public void setWordCount(int wordCountIn) {
      wordCount = wordCountIn;
   }
}