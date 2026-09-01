class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0;

        int n = nums.length;

        // explore every number
        // reject when j>=2 || nums[i]==nums[j-2]

        for(int i=0;i<n;i++){
            if(j<2 || nums[i] != nums[j-2]){
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}