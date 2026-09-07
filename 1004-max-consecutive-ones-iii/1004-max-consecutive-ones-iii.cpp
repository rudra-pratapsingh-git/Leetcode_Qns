class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int n = nums.size();
        int left = 0;
        int right = 0;
        int zeroes = 0;
        int maxLen = 0;

        while(right < n){
            if(nums[right] == 0){
                zeroes ++;
            }

            if(zeroes >k){
                if(nums[left] == 0){
                    zeroes--;
                }
                left++;
            }

            if(zeroes<=k){
                int len = right-left+1;
                maxLen = max(maxLen,len);
            }

            right++;
        }

        return maxLen;
    }
};