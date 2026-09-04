class Solution {
public:

    bool isPalindrome(string &s , int l, int r){
        while(l<r){
            if(s[l] != s[r]) return false;
            l++;
            r--;
        }
        return true;
    }
    bool validPalindrome(string s) {
        
        int n = s.size();

        if(n<=2) return true;

        int l = 0;
        int r = n-1;

        while(l<r){

            if(s[l] != s[r]){
                return isPalindrome(s,l+1,r) || isPalindrome(s,l,r-1);
            }
            l++;
            r--;
        }

        return true;

    }
};