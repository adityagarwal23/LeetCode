int minAddToMakeValid(char* s) {
    int bal = 0, ans = 0;
    while (*s != NULL) {
        *s == '(' ? bal++ : bal--;
        if (bal == -1) {
            bal = 0;
            ans++;
        }
        s++;
    }
    return ans + bal;
}