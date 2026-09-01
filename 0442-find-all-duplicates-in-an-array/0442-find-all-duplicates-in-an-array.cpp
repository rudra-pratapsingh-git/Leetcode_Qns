class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        
        vector<int> ans;

        for(auto x : nums){
            int index = abs(x) - 1;

            if(nums[index] < 0){
                ans.push_back(abs(x));
            }else{
                nums[index] = -nums[index];
            }
        }

        return ans;


    }
};