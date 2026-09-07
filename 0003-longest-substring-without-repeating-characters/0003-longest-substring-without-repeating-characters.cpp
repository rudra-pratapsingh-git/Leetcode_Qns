class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int n = s.size();
        vector<int> hash(256,-1);

        int left = 0;
        int right = 0;
        int maxLen = 0;

        while(right<n){
            if(hash[s[right]] != -1 ){
                //charcater has occured once before

                if(hash[s[right]] >= left){
                    // charcter repeats within the window
                    left = hash[s[right]] + 1;
                }
            }
            int len = right - left + 1;
            maxLen = max(maxLen,len);
            hash[s[right]] = right;
            right++;
        }

        return maxLen;
    }
};