class Solution {
    vector<string> res;
public:
    vector<string> generateParenthesis(int n) {
        res.clear();
        generate("", n, 0);
        return res;
    }
private:
    void generate(string expr, int openRemaining, int closeAvailable) {
        if (openRemaining == 0 and closeAvailable == 0) {
            res.push_back(expr);
            return;
        }
        if (closeAvailable > 0) {
            generate(expr + ")", openRemaining, closeAvailable - 1);
        }
        if (openRemaining > 0) {
            generate(expr + "(", openRemaining - 1, closeAvailable + 1);
        }
    }
};