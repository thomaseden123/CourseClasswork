#include <iostream>
using namespace std;
int main() {
    while(true) {
        int i;
        cin >> i;
        switch(i) {
            case 1:
            case 2:
            case 3:
                cout << "inside switch " << i << "\n";
                continue;
            default:
                cout << "inside default\n";
                break;
            }
            cout << "Bottom of while " << i << endl;
            break;
    }
}