int dfa[4][2] = {
    {0, 1}, //state 0
    {0, 2}, // state 1
    {0, 3}, // state 2
    {3, 3} // state 3
};
bool threeConsecutiveOdds(int* arr, int arrSize) {
    int state = 0;
    for (int i = 0; i < arrSize; i++) {
        state = dfa[state][arr[i] & 1];
        if(state == 3) {
            return true;
        }
    }
    return false;
}