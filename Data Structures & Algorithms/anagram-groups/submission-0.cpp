class Solution {
public:

    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>>answerString;

        unordered_map<string, vector<string>> stringMapper;

        for(auto str : strs) {
            string temp = str;
            sort(temp.begin(), temp.end());
            stringMapper[temp].push_back(str);
        }

        for(auto elem : stringMapper) {
            answerString.push_back(elem.second);
        }

        return answerString;
    }
};
