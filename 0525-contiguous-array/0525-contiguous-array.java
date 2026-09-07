class Solution {
    public int findMaxLength(int[] nums) {
        
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen=0;

        for(int i = 0;i<n;i++){
            if(nums[i] == 0){
                sum -=1;
            }else{
                sum +=1;
            }
            if(sum == 0) maxLen = i+1;
            if(map.containsKey(sum)){
                int firstIndex = map.get(sum);
                int len = i - firstIndex;
                maxLen = Math.max(maxLen,len);
            }else{
                map.put(sum,i);
            }
        }

        return maxLen;

    }
}