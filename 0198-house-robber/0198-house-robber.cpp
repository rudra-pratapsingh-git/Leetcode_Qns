class Solution {
public:
    int rob(vector<int>& nums) {
        //optimizedc code
        int n = nums.size();

        int prev = nums[0];
        int prev2 = 0;
        int curr ;

        for(int i=1;i<n;i++){
            int notrob = prev;
            int rob = nums[i];

            if(i>1) rob += prev2;

            curr = max(rob,notrob);

            prev2 = prev;
            prev = curr;

        }
        return prev;

    }
};