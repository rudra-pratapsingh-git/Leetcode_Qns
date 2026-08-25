class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();


        // x + y + z =0
        // y+z = -x
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            int l = i+1;
            int r = n-1;
            int x = nums[i];
            while(l<r){
                if(nums[l]+nums[r]+x == 0){
                    list.add(Arrays.asList(x,nums[l],nums[r]));

                    //skip duplicate y and z
                    while(l<r && nums[l]==nums[l+1]) l++;
                    while(l<r && nums[r] == nums[r-1]) r--;
                    l++;r--;
                }else if(nums[l]+nums[r] + x>0){
                    r--;
                }else{
                    l++;
                }

            }
        }

        return list;
    }
}