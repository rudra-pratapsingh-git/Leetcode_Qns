class Solution {
public:
    vector<int> pivotArray(vector<int>& nums, int pivot) {
        vector<int> lesser;
        vector<int> equal;
        vector<int> greater;

        for(int x: nums){
            if(x<pivot){
                lesser.push_back(x);
            }else if(x==pivot){
                equal.push_back(x);   
            }else{
                greater.push_back(x);
            }
        }

        int i=0;

        for(int x:lesser){
            nums[i++] = x;
        }

        for(int x: equal){
            nums[i++] = x;
        }
        for(int x: greater){
            nums[i++] = x;
        }

        return nums;
    }
};