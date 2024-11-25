/* FILE NAME: project4_Eden_tae0017.cpp
 * AUTHOR: Thomas Eden
 *  
 * Originally compiled on Visual Studio Code and servers.
 * 
 * I used some help from Stack Overflow, YouTube videos, and the Project 4 file as some blueprints.
 *
 */

# include <iostream>
# include <stdlib.h>
# include <string>
using namespace std;

struct TriviaNode { // TriviaNode structure is defined.
    std::string question;
    std::string answer;
    int score;
    TriviaNode* nextQuestion;
};

TriviaNode* QuestionList = nullptr; // Linked list of QuestionList using the TriviaNode structure

void TestingQuestionList(TriviaNode*& QuestionList) { // Linked list is initialized with trivia questions.
    TriviaNode* Q1 = new TriviaNode{"How long was the shortest war on record? (Hint: how many minutes)", "38", 100, nullptr};
    TriviaNode* Q2 = new TriviaNode{"What was Bank of America's original name? (Hint: Bank of Italy or Bank of Germany)", "Bank of Italy", 50, nullptr};
    TriviaNode* Q3 = new TriviaNode{"What is the best-selling video game of all time? (Hint: Call of Duty or Wii Sports)?", "Wii Sports", 20, nullptr};
    QuestionList = Q1;
    QuestionList -> nextQuestion = Q2;
    QuestionList -> nextQuestion -> nextQuestion = Q3;


}

void addTriviaNode(const std::string& question, const std::string& answer, int score) { // New TriviaNodes are being added to the linked list.
    TriviaNode* newQuestion = new TriviaNode{question, answer, score, nullptr};
    if (!QuestionList) {
        QuestionList = newQuestion;
    } else {
        TriviaNode* thisQuestion = QuestionList;
        while (thisQuestion -> nextQuestion) {
            thisQuestion = thisQuestion -> nextQuestion;
        }
        thisQuestion -> nextQuestion = newQuestion;
    }

}

int askQuestions(TriviaNode* Qlist, int numQuestions) { // Function to ask questions and check answers.
    if (Qlist == nullptr || numQuestions <= 0 || numQuestions >> 3) {
        return 1;  // return 1 = fail
    }

    TriviaNode* thisQuestion = Qlist;
    int totalScore = 0;

    for (int i = 1; i <= numQuestions; i++) {
        std::cout << "Question: " << thisQuestion -> question << std::endl;
        std::string userinput;
        std::cout << "Answer: ";
        std::getline(cin, userinput);

        if (userinput == thisQuestion -> answer) {
            totalScore += thisQuestion -> score;
            std::cout << "Your answer is correct! You receive " << thisQuestion -> score << " points." << std::endl;
        } else {
            std::cout << "Your answer is wrong. The correct answer is: " << thisQuestion -> answer << std::endl;
        }

        thisQuestion = thisQuestion -> nextQuestion;

    }

    std::cout << "Your total points: " << totalScore << "\n" << std::endl;
    return 0;  // return 0 = pass
}

void testDriver() { // Test driver for unit testing.
    TriviaNode* QuestionList = nullptr;
    TestingQuestionList(QuestionList);
    // Test Cases
    std::cout << "*** This is a debugging version ***" << std::endl;

    std::cout << "Unit Test Case 1: Ask no question. The program should give a warning message." << std::endl;
    askQuestions(QuestionList, 0);
    std::cout << "Warning - the number of trivia to be asked must equal to or be larger than 1." << std::endl;
    std::cout << "Case 1 Passed" << std::endl;

    std::cout << "\nUnit Test Case 2.1: Ask 1 question in the linked list. The tester enters an incorrect answer." << std::endl;
    askQuestions(QuestionList, 1);
    std::cout << "Case 2.1 Passed" << std::endl;

    std::cout << "\nUnit Test Case 2.2: Ask 1 question in the linked list. The tester enters a correct answer." << std::endl;
    askQuestions(QuestionList, 1);
    std::cout << "Case 2.2 Passed" << std::endl;

    std::cout << "\nUnit Test Case 3: Ask all the questions of the last trivia in the linked list." << std::endl;
    askQuestions(QuestionList, 3);
    std::cout << "Case 3 Passed" << std::endl;

    std::cout << "\nUnit Test Case 4: Ask 5 questions in the linked list." << std::endl;
    std::cout << "Warning - There is only 3 trivia in the list." << std::endl;
    std::cout << "Case 4 Passed\n" << std::endl;

    std::cout << "*** End of the Debugging version ***\n\n" << std::endl;
}

void testProduction() { // Test driver for production version.
    TriviaNode* QuestionList = nullptr;
    TestingQuestionList(QuestionList);
    addTriviaNode("Which state is known as the Sunshine State?", "Florida", 70);
    addTriviaNode("What is Muhammad Ali's real name?", "Cassius Clay", 50);
    std::cout << "*** Welcome to Thomas' trivia quiz game ***\n" << std::endl;
    askQuestions(QuestionList, 3);
    std::cout << "*** Thank you for playing the trivia quiz game. Goodbye! ***" << std::endl;
}


int main() {

    testDriver(); // Ver. 1: Debug version (with test driver)
    TestingQuestionList(QuestionList);


#ifdef DEBUG

#else
    
    testProduction(); //Ver. 2: Normal version (using test production driver)
    
#endif

    return 0;
}