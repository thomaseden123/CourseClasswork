   /**
 * Represents info about customer's bank loan.
 * @author - Thomas Eden
 * @version - October 12, 2022
 */

public class BankLoan {
	// constant fields
   private static final int MAX_LOAN_AMOUNT = 100000;
   private static int loansCreated = 0;

   // instance variables (can be used within the class)
   private String customerName;
   private double balance, interestRate;
   
   /**
    * Constructor sets customerName and interestRate;
    * increments loansCreated.
    * @param customerNameIn for customerName
    * @param interestRateIn for interestRate
    */

   public BankLoan(String customerNameIn, double interestRateIn) { 
      customerName = customerNameIn;
      interestRate = interestRateIn;
      balance = 0;
      loansCreated++;
   }
   
   /**
    * borrowFromBank method.
    * @param amount for amount
    * @return wasLoanMade
    */
     

   public boolean borrowFromBank(double amount) {
      
      boolean wasLoanMade = false;
      
      if (balance + amount < MAX_LOAN_AMOUNT) {
         wasLoanMade = true;
         balance += amount;
      }
   
      return wasLoanMade;
   }
   
   /**
    * payBank method.
    * @param amountPaid for amountPaid
    * @return newBalance
    */

   public double payBank(double amountPaid) {
      double newBalance = balance - amountPaid;
      if (newBalance < 0) {
         balance = 0;
         // paid too much, return the overcharge
         return Math.abs(newBalance);
      }
      else {
         balance = newBalance;
         return 0;
      }
   }
   
   /**
    * Gets balance for each loan.
    * @return balance
    */
   
   public double getBalance() {
      return balance;
   }
   
   /**
    * Sets interest rate for each loan.
    * @param interestRateIn - interestRate
    * @return interestRateIn as boolean
    */
   
   public boolean setInterestRate(double interestRateIn) {
   
      if (interestRateIn >= 0 && interestRateIn <= 1) {
         interestRate = interestRateIn;
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
    * Gets interest rate for each loan.
    * @return interestRate
    */
   
   public double getInterestRate() {
      return interestRate;
   }
   
   /**
    * Gives balance and interest rate for bank loan.
    */
   
   public void chargeInterest() {
      balance = balance * (1 + interestRate);
   }
   
   /**
    * Gives summary of customer and bank loan.   
    * @return summary of BankLoan object
    */
   
   public String toString() {
      String output = "Name: " + customerName + "\r\n" 
         + "Interest rate: " + interestRate + "%\r\n" 
         + "Balance: $" + balance + "\r\n";
      return output;
   }
   
   /**
    * Method for isAmountValid.
    * @param amount for amount
    * @return amount in boolean
    */
   
   public static boolean isAmountValid(double amount) {
      if (amount >= 0) {
         return true;
      }
      return false;
   }
   
   /**
    * Method for isAmountValid.
    * @param loan for loan
    * @return loan in boolean
    */
   
   public static boolean isInDebt(BankLoan loan) {
      if (loan.getBalance() > 0) {
         return true;
      }
      return false;
   }
   
   /**
    * Gets number of loans created.
    * @return loans for bank loans created.
    */
   
   public static int getLoansCreated() {
      return loansCreated;
   }
   
   /**
    * Resets number of loans created.
    */
   
   public static void resetLoansCreated() {
      loansCreated = 0;
   }   
}
