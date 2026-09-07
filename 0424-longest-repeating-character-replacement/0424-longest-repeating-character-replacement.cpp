class Solution {
public:
    int characterReplacement(string s, int k) {
        int n = s.size();
        vector<int> freq(26,0);

        int maxLen = 0;
        int left = 0;
        int right = 0;

        int maxFreq = 0;
        while(right<n){
            freq[s[right]-'A']++;
            maxFreq = max(maxFreq,freq[s[right]-'A']);

            while((right-left+1)-maxFreq>k){
                // while less repeating charcaters > k, increment l
                freq[s[left]-'A']--;
                left++;
            }
            //window becomes valid again

            int windowSize = right - left + 1;
            maxLen = max(maxLen,windowSize);
            right++;
        }
        return maxLen;
    }
};