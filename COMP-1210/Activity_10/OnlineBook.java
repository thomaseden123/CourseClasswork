  /**
 * Represents info for online books.
 * @author - Thomas Eden
 * @version - November 1, 2022
 */

public class OnlineBook extends OnlineTextItem {
   protected String author;
   
   /**
    * Set up constructor for OnlineBook.
    * @param nameIn - name
    * @param priceIn - price
    */
   
   public OnlineBook(String nameIn, double priceIn) {
      super(nameIn, priceIn);
      author = "Author Not Listed";
   }
   
   /**
    * Gives summary of the online book.
    * @return the String representation of OnlineBook
    */
   
   public String toString() {
      return name + " - " + author + ": $" + price;
   }
   
   /**
    * Sets the name of the author.
    * @param authorIn - author
    */
   
   public void setAuthor(String authorIn) {
      author = authorIn;
   }
}