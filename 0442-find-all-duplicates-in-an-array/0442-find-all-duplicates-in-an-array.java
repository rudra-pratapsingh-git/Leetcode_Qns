class Solution {
    public List<Integer> findDuplicates(int[] nums) {

        int n = nums.length;

        List<Integer> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            int index = Math.abs(nums[i])-1;

            if(nums[index] < 0 ){
                //already visited

                list.add(Math.abs(nums[i]));
            }else{
                nums[index]  = -nums[index];
            }
        }

        return list;

















        // List<Integer> list = new ArrayList<>();

        // HashMap<Integer,Integer> map = new HashMap<>();

        // int n = nums.length;

        // for(int i=0;i<n;i++){
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        // }

        // for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        //     if(entry.getValue() > 1) list.add(entry.getKey());
        // }

        // return list;
    }
}