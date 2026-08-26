class Solution {
public:
    int maxArea(vector<int>& height) {
        int n = height.size();

        int left = 0;
        int right = n-1;

        int maxWater = INT_MIN;

        while(left < right){
            int high = min(height[left],height[right]);

            int curr = high*(right - left);

            maxWater = max(maxWater,curr);
            
            if(height[left] < height[right]) left++;
            else right--;

        }

        return maxWater;
    }
};