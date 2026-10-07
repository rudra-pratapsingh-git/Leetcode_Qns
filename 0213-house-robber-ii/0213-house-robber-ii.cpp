class Solution {
public:
    int robhouse(vector<int>& nums,int start,int end){
        int prev2 = 0;
        int prev = nums[start];
        int curr;

        for(int i=start+1;i<end;i++){
            int nottake = prev;
            int take = nums[i];
            if(i>1) take += prev2;
            curr = max(take,nottake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    int rob(vector<int>& nums) {
        int n = nums.size();

        if(n==1) return nums[0];

        int robfirst = robhouse(nums,0,n-1);
        int roblast = robhouse(nums,1,n);
        return max(robfirst,roblast);
    }
};