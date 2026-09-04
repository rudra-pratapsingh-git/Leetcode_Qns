class Solution {

    public void reverse(int [] nums, int l,int r){
        r--;
        while(l<r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;

            l++;
            r--;
        }
    }


    public void rotate(int [] nums,int first,int mid,int last){
        reverse(nums,first,mid);
        reverse(nums,mid,last);
        reverse(nums,first,last);
    }
    public int stablePartition(int [] nums, int left,int right, int pivot){
        if(right - left <=1 ){
            if(right-left == 1 && nums[left] <= pivot){
                return 1;
            }
            return 0;
        }

        int mid = left + (right - left )/2;

        int leftCount = stablePartition(nums,left,mid,pivot);
        int rightCount = stablePartition(nums,mid,right,pivot);

        int first = left + leftCount;
        int second = mid;
        int third = mid + rightCount;

        rotate(nums,first,second,third);

        return leftCount + rightCount;
    }
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;

        int lessCount = stablePartition(nums,0,n,pivot-1);
        stablePartition(nums,lessCount,n,pivot);

        return nums;
    }
}