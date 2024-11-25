/**
 * Represents info about the customer.
 * @author - Thomas Eden
 * @version - October 18, 2022
 */

public class Customer implements Comparable<Customer> {

   private String name = "";
   private String location = "";
   private double balance = 0;
   
   /**
    * Constructor sets name, location, and balance.
    * @param nameIn for name
    */

   public Customer(String nameIn) {
      name = nameIn;
      location = "";
      balance = 0;
   }
   
   /**
    * Sets location with parameter locationIn.
    * @param locationIn is set as parameter
    */
   
   public void setLocation(String locationIn) {
      location = locationIn;
   }
   
   /**
    * Changes balance with parameter amount.
    * @param amount is set as parameter
    */

   public void changeBalance(double amount) {
      balance = amount;
   }
   
   /**
    * Gets location of customer.
    * @return location as String
    */

   public String getLocation() {
      return location;
   }
   
   /**
    * Gets balance of customer.
    * @return balance as double
    */

   public double getBalance() {
      return balance;
   }
   
   /**
    * Sets location with parameters city and state.
    * @param city is set as parameter
    * @param state is set as parameter
    */

   public void setLocation(String city, String state) {
      location = city + ", " + state;
   }
   
   /**
    * Accept parameters of Customer obj.
    * @param obj for Customer
    * @return values of 0, -1, or 1
    */

   public int compareTo(Customer obj) {	
      if (Math.abs(this.balance - obj.getBalance()) < 0.000001) {
         return 0;
      } else if (this.balance < obj.getBalance()) {
         return -1;
      } else {
         return 1;
      }
   }
   
   /**
    * String method for customer.
    * @return name, getLocation(), and getBalance()
    */
   
   public String toString() {
      return name + "\n" + getLocation() + "\n"
                  + "$" + getBalance();
      
   }
}
