class Solution {
    bool adj(char c1, char c2) {
        if ((c1 == 'a' and c2 == 'z') or (c1 == 'z' and c2 == 'a')){
            return true;
        } 
        return abs(c1 - c2) == 1;
    }
public:
    string resultingString(string s) {
        stack<char> st;
        for (char c : s) {
            if (!st.empty() and adj(st.top(), c)) {
                st.pop();
            } else {
                st.push(c);
            }
        }
    
    string res;
    while(!st.empty()) {
        res.push_back(st.top());
        st.pop();
    }
    reverse(res.begin(), res.end());
    return res;
    }
 };