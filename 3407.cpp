class Solution {
public:
    bool hasMatch(string s, string p) {
        auto k = p.find('*');
        auto b = p.substr(0, k);
        auto e = p.substr(k + 1);
        auto i = s.find(b);
        auto j = s.rfind(e);
        return i != string::npos and 
               j != string::npos and
               i + b.size() <= j;
    }
};