class Solution {
public:
    bool isAnagram(string s, string t) {
        unordered_map<int, int> counter1, counter2;

        for(auto x : s){
            counter1[x]++;
        }

        for(auto y : t){
            counter2[y]++;
        }

        return counter1 == counter2;

    }
};
