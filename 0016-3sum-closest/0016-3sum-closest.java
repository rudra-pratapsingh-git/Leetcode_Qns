class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        int ans = nums[0]+nums[1]+nums[2];
        for(int i=0;i<n-2;i++){
            int x = nums[i];
            int l = i+1;
            int r = n-1;

            while(l<r){
                int sum = x + nums[l]+nums[r];

                if(Math.abs(sum-target) < Math.abs(ans-target)){
                    ans = sum;
                }

                if(sum == target){
                    return sum;
                }else if(sum>target){
                    r--;
                }else{
                    l++;
                }
            }


        }
        return ans;
    }
}