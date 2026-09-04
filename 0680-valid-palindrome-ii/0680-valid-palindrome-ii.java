class Solution {

    public boolean isPalindrome(String s, int l, int r){
        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {

        // don't erase anything 
        // just adjust the pointers
        
        if(s.length()<=2) return true;
        int n = s.length();
        int l = 0;
        int r = n-1;

        while(l<r){
            if(s.charAt(l) != s.charAt(r)){
                return isPalindrome(s,l+1,r) || isPalindrome(s,l,r-1);
            }

            l++;
            r--;
        }

        return true;

    }
}