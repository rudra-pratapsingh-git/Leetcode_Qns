class Solution {
    public int rob(int[] nums) {
        int n  = nums.length;

        //TABULATION METHOD
        // REFER CPP for OPTIMIZED METHOD

        int dp[] = new int[n];
        dp[0] = nums[0];
        //dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 1;i<n;i++){
            int notrob = dp[i-1];
            int rob = nums[i];
            if(i>1){
                rob += dp[i-2];

            }
            dp[i] = Math.max(notrob,rob);    

        }

        return dp[n-1];
    }
}