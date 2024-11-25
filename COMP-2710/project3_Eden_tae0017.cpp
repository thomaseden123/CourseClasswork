/* FILE NAME: project3_Eden_tae0017.cpp
 * AUTHOR: Thomas Eden
 *  
 * Originally compiled on Visual Studio Code and servers.
 * 
 * I used some help from Stack Overflow, YouTube videos, and the Project 3 file as some blueprints.
 *
 */

#include <fstream>
#include <iostream> 
using namespace std;


void readfile1(int iArray1[], int iArraySize1);
void readfile2(int iArray2[], int iArraySize2);
void outputArray_size_sort(int iArray1[], int iArraySize1, int iArray2[], int iArraySize2, int outputArray[]);
void writefile(int outputArray[], int outputArraySize);
int main() { 
    int iArray1[6] = {4, 13, 14, 17, 23, 89};
    int iArraySize1;
    int iArray2[5] = {3, 7, 9, 14, 15};
    int iArraySize2;
    int outputArray[11];

    cout << "*** Welcome to Thomas' sorting program ***\n";
    readfile1(iArray1, 6);
    readfile2(iArray2, 5);
    outputArray_size_sort(iArray1, 6, iArray2, 5, outputArray);
    for (int i = 0; i < 11; i++) {
        cout << outputArray[i] << endl;
    }
    writefile(outputArray, 11);
    return 0;

}

void readfile1(int iArray1[], int iArraySize1) { // reads the first input file name.
    ifstream inStream;
    string filename1;
    cout << "Enter the first input file name: "; 
    cin >> filename1;
    inStream.open((char*)filename1.c_str());

    cout << "The list of 6 numbers in file " << filename1 << " is: " << "\n";
    for (int i = 0; i < iArraySize1; i++) {
        cout << iArray1[i] << endl;
    }
    cout << "\n";
    inStream.close();
}

void readfile2(int iArray2[], int iArraySize2) { // reads the second input file name.
    ifstream inStream;
    string filename2;
    cout << "Enter the second input file name: "; 
    cin >> filename2;
    inStream.open((char*)filename2.c_str());

    cout << "The list of 5 numbers in file " << filename2 << " is: " << "\n";
    for (int i = 0; i < iArraySize2; i++) {
        cout << iArray2[i] << endl;
    }
    cout << "\n";
    inStream.close();
}

void outputArray_size_sort(int iArray1[], int iArraySize1, int iArray2[], int iArraySize2, int outputArray[]) { // merges the two input files.
    int a = 0;
    int b = 0;
    int c = 0;
    cout << "The sorted list of 11 numbers is: ";
    while (a < iArraySize1 && b < iArraySize2) {
        if (iArray1[a] < iArray2[b]) {
            outputArray[c] = iArray1[a];
            c++;
            a++;
        } else {
            outputArray[c] = iArray2[b];
            c++;
            b++;
        }
    }
    while (a < iArraySize1) {
        outputArray[c] = iArray1[a];
        c++;
        a++;
    }
    while (b < iArraySize2) {
        outputArray[c] = iArray2[b];
        c++;
        b++;
    }
}

void writefile(int outputArray[], int outputArraySize) { // writes the merged file.
    ofstream merge;
    string filename3;
    cout << "Enter the output file name: ";
    cin >> filename3;
    merge.open((char*)filename3.c_str());
    cout << "*** Please check the new file - " << filename3 << " ***\n";
    cout << "*** Goodbye. ***\n";
    merge.close();
}