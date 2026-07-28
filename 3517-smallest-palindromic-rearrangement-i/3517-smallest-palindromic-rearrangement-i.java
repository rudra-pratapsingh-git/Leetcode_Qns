class Solution {
    public String smallestPalindrome(String s) {
        int freq[] = new int[26];

        StringBuilder left = new StringBuilder();
        char mid = 0;

        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }

        for(int i=0;i<26;i++){
            for(int j=0;j<freq[i]/2;j++){
                left.append((char)(i+'a'));
            }
            if(freq[i]%2==1){
                mid = (char)(i+'a');
            }
        }

        StringBuilder right = new StringBuilder(left).reverse();

        if(mid!=0){
            return left.toString()+mid+right.toString();
        }

        return left.toString()+right.toString();

    }
}