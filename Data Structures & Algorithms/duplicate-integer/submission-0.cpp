class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
            set<int>hashSet;
            for(int i=0; i<nums.size(); i++) {
                if(hashSet.find(nums[i])==hashSet.end()) {
                        hashSet.insert(nums[i]);
                } else {
                    return true;
                }
            }

        return false;
    }
};
