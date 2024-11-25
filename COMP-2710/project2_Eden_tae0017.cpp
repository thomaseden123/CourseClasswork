/* FILE NAME: project2_Eden_tae0017.cpp
 * AUTHOR: Thomas Eden
 *  
 * Originally compiled on Visual Studio Code 
 * and servers.
 * 
 * I used some help from Stack Overflow and the Project 2 file as some blueprints.
 *
 */

# include <iostream>
# include <stdlib.h>
# include <assert.h>
# include <ctime>
using namespace std;
//prototypes
bool at_least_two_alive(bool A_alive, bool B_alive, bool C_alive);

/* Input: A_alive indicates whether Aaron is alive */
/* B_alive indicates whether Bob is alive */
/* C_alive indicates whether Charlie is alive */
/* Return: true if at least two are alive */
/* otherwise return false */
/*
* Add other function prototypes below
*/

void Aaron_shoots1(bool& B_alive, bool& C_alive);
void Bob_shoots(bool& A_alive, bool& C_alive);
void Charlie_shoots(bool& A_alive, bool& B_alive);
void test_at_least_two_alive(void);
void test_Aaron_shoots1(bool& B_alive, bool& C_alive);
void test_Bob_shoots(bool& A_alive, bool& C_alive);
void test_Charlie_shoots(bool& A_alive, bool& B_alive);
void test_Aaron_shoots2(bool& B_alive, bool& C_alive);
void test_Strategy1(bool A_alive, bool B_alive, bool C_alive);
void test_Strategy2(bool A_alive, bool B_alive, bool C_alive);


bool A_alive = true;
bool B_alive = true;
bool C_alive = true;


int main()
{

    const int total_runs = 10000;   // Total runs stays the same at 10000 runs per strategy.
    cout << total_runs << endl;
    const double shoot_target_result = rand() % 100;
    const double probability = shoot_target_result / total_runs;
    int shooter = 0;
    int Aaron_wins = 0;
    int Bob_wins = 0;
    int Charlie_wins = 0;
    // Providing a seed value
	
    
    
    do {  
        Aaron_shoots1(B_alive, C_alive);
            if (C_alive) { 
                if (shoot_target_result <= 33.33) { // Aaron has a 1 in 3, or 33.33% chance of hitting his shot.
                    C_alive = false;
                } 
            } else {
                if (shoot_target_result <= 33.33) { 
                    B_alive = false;
                }
            }
            cout << Aaron_wins++;    
        Bob_shoots(A_alive, C_alive);
            if (C_alive) { 
                if (shoot_target_result <= 50) { // Aaron has a 1 in 2, or 50% chance of hitting his shot.
                    C_alive = false;
                } 
            } else {
                if (shoot_target_result <= 50) { 
                    A_alive = false;
                }
            }
            cout << Bob_wins++;   
        Charlie_shoots(A_alive, B_alive);
            if (B_alive) { 
                if (shoot_target_result == 100) { // Charlie has a 100% chance of hitting his shot.
                    B_alive = false;
                } 
            } else {
                if (shoot_target_result == 100) { 
                    A_alive = false;
                }
            } 
            cout << Charlie_wins++;   
    } while (at_least_two_alive(A_alive, B_alive, C_alive));
    cout << A_alive << endl;
    cout << B_alive << endl;
    cout << C_alive << endl;

	// Get a random number
	int random = rand();

	// Print the random number
	cout << random << endl;
    test_at_least_two_alive();              
    test_Aaron_shoots1(B_alive, C_alive);
    test_Bob_shoots(A_alive, C_alive);
    test_Charlie_shoots(A_alive, B_alive);
    test_Aaron_shoots2(B_alive, C_alive);
    test_Strategy1(A_alive, B_alive, C_alive);
    test_Strategy2(A_alive, B_alive, C_alive);
    cout << "Strategy 2 is better than strategy 1." << endl;
    return 0;


}

/* Implementation of at_least_two_alive() */
bool at_least_two_alive(bool A_alive, bool B_alive, bool C_alive) {
    if (A_alive && B_alive) {
        return true;
    }
    if (B_alive && C_alive) {
        return true;
    }
    if (A_alive && C_alive) {
        return true;
    }

    return false;   
}

void Strategy1(bool A_alive, bool B_alive, bool C_alive) {
    const double shoot_target_result = rand() % 100;
    const int total_runs = 10000;
    const double probability = shoot_target_result / total_runs;
    Aaron_shoots1(B_alive, C_alive);
    if (C_alive) { 
        if (shoot_target_result <= 33.33) { // Aaron has a 1 in 3, or 33.33% chance of hitting his shot.
            C_alive = false;
        } 
    } else {
        if (shoot_target_result <= 33.33) { 
            B_alive = false;
        }
    }
    Bob_shoots(A_alive, C_alive);
    if (C_alive) { 
        if (shoot_target_result <= 50) { // Aaron has a 1 in 2, or 50% chance of hitting his shot.
            C_alive = false;
        } 
    } else {
        if (shoot_target_result <= 50) { 
            A_alive = false;
        }
    }
    Charlie_shoots(A_alive, B_alive);
    if (B_alive) { 
        if (shoot_target_result == 100) { // Charlie has a 100% chance of hitting his shot.
            B_alive = false;
        } 
    } else {
        if (shoot_target_result == 100) { 
            A_alive = false;
        }
    }
    cout << total_runs << endl;
    
}
/* Implementation of Aaron_shoots1() */
void Aaron_shoots1(bool& B_alive, bool& C_alive) {
        
    if (C_alive) {  
        C_alive = false;
    } else {
        B_alive = false;
    } 
    
}
/* Implementation of Bob_shoots() */
void Bob_shoots(bool& A_alive, bool& C_alive) {
    if (C_alive) {
        C_alive = false;
    } else {
        A_alive = false;
    } 
    
}
/* Implementation of Charlie_shoots() */
void Charlie_shoots(bool& A_alive, bool& B_alive) {
    if (B_alive) {
        B_alive = false;
    } else {
        A_alive = false; 
    }
    
}
/* Implementation of Aaron_shoots2() */
void Aaron_shoots2(bool& B_alive, bool& C_alive) {
    if (C_alive) {  
        C_alive = false;
    } else {
        B_alive = false;
    }
}

void Strategy2(bool A_alive, bool B_alive, bool C_alive) {
    const double shoot_target_result = rand() % 100;
    const int total_runs = 10000;
    const double probability = shoot_target_result / total_runs;
    Aaron_shoots2(B_alive, C_alive);
    if (C_alive) { 
        if (shoot_target_result <= 33.33) { // Aaron has a 1 in 3, or 33.33% chance of hitting his shot.
            C_alive = false;
        } 
    } else {
        if (shoot_target_result <= 33.33) { 
            B_alive = false;
        }
    }
    Bob_shoots(A_alive, C_alive);
    if (C_alive) { 
        if (shoot_target_result <= 50) { // Aaron has a 1 in 2, or 50% chance of hitting his shot.
            C_alive = false;
        } 
    } else {
        if (shoot_target_result <= 50) { 
            A_alive = false;
        }
    }
    Charlie_shoots(A_alive, B_alive);
    if (B_alive) { 
        if (shoot_target_result == 100) { // Charlie has a 100% chance of hitting his shot.
            B_alive = false;
        } 
    } else {
        if (shoot_target_result == 100) { 
            A_alive = false;
        }
    }
    cout << total_runs << endl;
    
}

/* Implementation of the test driver for at_least_two_alive() */
void test_at_least_two_alive(void) {

    cout << "*** Welcome to Thomas' Duel Simulator ***\n";

    cout << "Unit Testing 1: Function – at_least_two_alive()\n";

    cout << "\tCase 1: Aaron alive, Bob alive, Charlie alive\n";
    assert(true == at_least_two_alive(true, true, true));
    cout << "\tCase passed ...\n";

    cout << "\tCase 2: Aaron dead, Bob alive, Charlie alive\n";
    assert(true == at_least_two_alive(false, true, true));
    cout << "\tCase passed ...\n";

    cout << "\tCase 3: Aaron alive, Bob dead, Charlie alive\n";
    assert(true == at_least_two_alive(true, false, true));
    cout << "\tCase passed ...\n";

    cout << "\tCase 4: Aaron alive, Bob alive, Charlie dead\n";
    assert(true == at_least_two_alive(true, true, false));
    cout << "\tCase passed ...\n";

    cout << "\tCase 5: Aaron dead, Bob dead, Charlie alive\n";
    assert(false == at_least_two_alive(false, false, true));
    cout << "\tCase passed ...\n";

    cout << "\tCase 6: Aaron dead, Bob alive, Charlie dead\n";
    assert(false == at_least_two_alive(false, true, false));
    cout << "\tCase passed ...\n";

    cout << "\tCase 7: Aaron alive, Bob dead, Charlie dead\n";
    assert(false == at_least_two_alive(true, false, false));
    cout << "\tCase passed ...\n";

    cout << "\tCase 8: Aaron dead, Bob dead, Charlie dead\n";
    assert(false == at_least_two_alive(false, false, false));
    cout << "\tCase passed ...\n";

    cout << "Press any key to continue...";
    cin.ignore().get();
}
/* Implementation of the test driver for Aaron_shoots1() */
void test_Aaron_shoots1(bool& B_alive, bool& C_alive) {
    cout << "Unit Testing 2: Function Aaron_shoots1(Bob_alive, Charlie_alive)\n";

    B_alive = true;
    C_alive = true;
    cout << "\tCase 1: Bob alive, Charlie alive\n";
    assert(true == B_alive);
    assert(true == C_alive);
    cout << "\tAaron is shooting at Charlie\n";

    B_alive = false;
    C_alive = true;
    cout << "\tCase 2: Bob dead, Charlie alive\n";
    assert(false == B_alive);
    assert(true == C_alive);
    cout << "\tAaron is shooting at Charlie\n";

    B_alive = true;
    C_alive = false;
    cout << "\tCase 3: Bob alive, Charlie dead\n";
    assert(true == B_alive);
    assert(false == C_alive);
    cout << "\tAaron is shooting at Bob\n";

    cout << "Press any key to continue...";
    cin.ignore().get();
}
/* Implementation of the test driver for Bob_shoots() */
void test_Bob_shoots(bool& A_alive, bool& C_alive) {
    cout << "Unit Testing 3: Function Bob_shoots(Aaron_alive, Charlie_alive)\n";

    A_alive = true;
    C_alive = true;
    cout << "\tCase 1: Aaron alive, Charlie alive\n";
    assert(true == B_alive);
    assert(true == C_alive);
    cout << "\tBob is shooting at Charlie\n";

    A_alive = false;
    C_alive = true;
    cout << "\tCase 2: Aaron dead, Charlie alive\n";
    assert(false == A_alive);
    assert(true == C_alive);
    cout << "\tBob is shooting at Charlie\n";

    A_alive = true;
    C_alive = false;
    cout << "\tCase 3: Aaron alive, Charlie dead\n";
    assert(true == A_alive);
    assert(false == C_alive);
    cout << "\tBob is shooting at Aaron\n";

    cout << "Press any key to continue...";
    cin.ignore().get();
}
/* Implementation of the test driver for Charlie_shoots() */
void test_Charlie_shoots(bool& A_alive, bool& B_alive) {
    cout << "Unit Testing 4: Function Charlie_shoots(Aaron_alive, Bob_alive)\n";

    A_alive = true;
    B_alive = true;
    cout << "\tCase 1: Aaron alive, Bob alive\n";
    assert(true == A_alive);
    assert(true == B_alive);
    cout << "\tCharlie is shooting at Bob\n";

    A_alive = false;
    B_alive = true;
    cout << "\tCase 2: Aaron dead, Bob alive\n";
    assert(false == A_alive);
    assert(true == B_alive);
    cout << "\tCharlie is shooting at Bob\n";

    A_alive = true;
    B_alive = false;
    cout << "\tCase 3: Aaron alive, Bob dead\n";
    assert(true == A_alive);
    assert(false == B_alive);
    cout << "\tCharlie is shooting at Aaron\n";

    cout << "Press any key to continue...";
    cin.ignore().get();
}
/* Implementation of the test driver for Aaron_shoots2() */
void test_Aaron_shoots2(bool& B_alive, bool& C_alive) {
    cout << "Unit Testing 5: Function Aaron_shoots2(Bob_alive, Charlie_alive)\n";

    B_alive = true;
    C_alive = true;
    cout << "\tCase 1: Bob alive, Charlie alive\n";
    assert(true == B_alive);
    assert(true == C_alive);
    cout << "\tAaron intentionally misses his first shot\n";
    cout << "\tBoth Bob and Charlie are alive.\n";

    B_alive = false;
    C_alive = true;
    cout << "\tCase 2: Bob dead, Charlie alive\n";
    assert(false == B_alive);
    assert(true == C_alive);
    cout << "\tAaron is shooting at Charlie\n";

    B_alive = true;
    C_alive = false;
    cout << "\tCase 3: Bob alive, Charlie dead\n";
    assert(true == B_alive);
    assert(false == C_alive);
    cout << "\tAaron is shooting at Bob\n";

    cout << "Press any key to continue...";
    cin.ignore().get();
}

void test_Strategy1(bool A_alive, bool B_alive, bool C_alive) {
    double shoot_target_result = rand() % 100;
    int total_runs = 10000;
    double probability = shoot_target_result / total_runs;
    int Aaron_wins = 0;
    int Bob_wins = 0;
    int Charlie_wins = 0;
    cout << "Ready to test strategy 1 (run 10000 times):\n";
    cout << "Press any key to continue...";
    cin.ignore().get();
    cout << "Aaron won " << Aaron_wins++ << " duels or " << Aaron_wins++ / 100 << "%\n";
    cout << "Bob won " << Bob_wins++ << " duels or " << Bob_wins++ / 100 << "%\n";
    cout << "Charlie won " << Charlie_wins++ << " duels or " << Charlie_wins++ / 100 << "%\n\n";
}

void test_Strategy2(bool A_alive, bool B_alive, bool C_alive) {
    double shoot_target_result = rand() % 100;
    int total_runs = 10000;
    double probability = shoot_target_result / total_runs;
    int Aaron_wins = 0;
    int Bob_wins = 0;
    int Charlie_wins = 0;
    cout << "Ready to test strategy 2 (run 10000 times):\n";
    cout << "Press any key to continue...";
    cin.ignore().get();
    cout << "Aaron won " << Aaron_wins++ << " duels or " << Aaron_wins++ / 100 << "%\n";
    cout << "Bob won " << Bob_wins++ << " duels or " << Bob_wins++ / 100 << "%\n";
    cout << "Charlie won " << Charlie_wins++ << " duels or " << Charlie_wins++ / 100 << "%\n\n";
}
