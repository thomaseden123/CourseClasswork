/* FILE NAME: project1_Eden_tae0017.cpp
 * AUTHOR: Thomas Eden
 * 
 * Originally compiled on Visual Studio Code 
 * and servers, but won't run outside campus.
 *
 * I used the Project 1 hints pdf as a guide
 * for my project.
 *
 * I also used some of my prior knowledge
 * from Java and looked at the
 * lecture PowerPoints to help. 
 */
#include <iostream>
using namespace std;

int main() {
   // VARIABLE INITIALIZATION
      
   double loan = 0;
   double interestRate = 0;
   double interestRateC = 0;
   double monthlyPaid = 0;
   double interestTotal = 0;
   double principal = 0;
   int currentMonth = 0;

      // CURRENCY FORMATTING
   cout.setf(ios::fixed);
   cout.setf(ios::showpoint);
   cout.precision(2);
      
      // USER INPUT
      // NOTE: For valid input, the loan, interest, and monthly payment must
      // be positive. The monthly payment must also be large enough to
      // terminate the loan.
      
   cout << "\nLoan Amount: ";
   cin >> loan;   
      
   // Your program will not move forward until a positive loan is entered   
   if (loan <= 0) {
      cout << "Invalid input. Please enter a positive loan amount.";
      cin >> loan;  
   } else {
      cout << "Interest Rate (% per year): ";
      cin >> interestRate;
   }
   
       
   
   // Your program will not move forward until a positive interest rate is entered   
   if (interestRate <= 0) {
      cout << "Invalid input. Please enter a positive interest rate.";
      cin >> interestRate;  
   } else {
      interestRate /= 12;
      interestRateC = interestRate / 100;
   }
    

   
   // Your program will not move forward until a monthly payment is sufficient      
   if (monthlyPaid <= 0) {
      cout << "Invalid input. Please enter a sufficient monthly payment.";
      cin >> monthlyPaid;  
   } else {
      cout << "Monthly Payments: ";
      cin >> monthlyPaid;
   }    
      
   cout << endl;
      
      // AMORTIZATION TABLE
    
   cout << "*****************************************************************\n"
            << "\tAmortization Table\n"
            << "*****************************************************************\n"
            << "Month\tBalance\t\tPayment\tRate\tInterest\tPrincipal\n";
                   
      // LOOP TO FILL TABLE
   while (loan > 0) {
      if (currentMonth == 0) {
         cout << currentMonth++ << "\t$" << loan;
      }
      if (loan < 1000) {
         cout << "\t" << "N/A\tN/A\tN/A\t\tN/A\n";
      }
      else {
         // Properly calculate and display “monthlyPaid” and “principal” when
         // (1) loan * (1 + interestRateC) < monthlyPaid
         // and (2) loan * (1 + interestRateC) >= monthlyPaid
         if (loan * (1 + interestRateC) >= monthlyPaid) {
            principal = monthlyPaid - (loan * interestRateC);
         } 
         else {
            principal = loan;
            monthlyPaid = loan * (1 + interestRateC); 
         }
         loan -= principal;
         interestTotal += (loan * interestRateC);   
      
      }
   
   }
   cout << "****************************************************************\n";
   cout << "\nIt takes " << currentMonth << " months to pay off "
      << "the loan.\n"
      << "Total interest paid is: $" << interestTotal;
   cout << endl << endl;
   return 0;
}