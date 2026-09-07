class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        
        int n = nums.size();
        int left = 0,right = 0;
        int sum = 0;
        int minLen = n+1;

        while(right < n){
            sum += nums[right];

            while(sum >= target){
                int len = right - left + 1;
                minLen = min(minLen,len);
                sum -= nums[left];
                left++;
            }
            right++;
        }

        if(minLen > n ) return 0;
        return minLen;
    }
};