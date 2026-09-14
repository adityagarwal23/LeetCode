class Solution {
public:
    vector<string> removeComments(vector<string>& source) {
        vector<string> res;
        bool block = false;
        string build;
        for (string line : source) {
            for (int i = 0; i < line.size(); i++) {
                string next2 = line.substr(i, 2);
                if (!block) {
                    if (next2 == "//") {
                        break;
                    }
                    else if(next2 == "/*") {
                        block = true, i++;
                    }
                    else {
                        build.push_back(line[i]);
                    }
                }
                else if (next2 == "*/"){
                    block = false, i++;
                }
            }
            if (build.size() && !block) {
                res.push_back(build), build.clear();
            }
        }
        return res;
    }
};