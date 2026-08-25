class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // fix 2 values and find combination of other two

        Arrays.sort(nums);
        int n = nums.length;

        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1  && nums[j]==nums[j-1]) continue;

                int x = nums[i];
                int y = nums[j];
                int l = j+1;
                int r = n-1;

                while(l<r){
                    long sum =(long) x + y + nums[l] + nums[r];

                    if(sum == target){
                        list.add(Arrays.asList(x,y,nums[l],nums[r]));

                        while(l<r && nums[l]==nums[l+1]) l++;
                        while(l<r && nums[r] == nums[r-1]) r--;
                        l++;
                        r--;
                    }else if(sum>target) r--;
                    else l++;
                }
            }
        }

        return list;
    }
}