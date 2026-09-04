class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = -Double.MAX_VALUE;

        int n = nums.length;
        double sum = 0;
        int l = 0;
        for(int r=0;r<n;r++){
            sum += nums[r];

            if(r-l>=k){
                sum -= nums[l];
                l++;
            }
            if(r-l == k-1){
                double avg = sum/k;
                maxAvg = Math.max(maxAvg,avg);
            }
        }

        return maxAvg;
    }
}