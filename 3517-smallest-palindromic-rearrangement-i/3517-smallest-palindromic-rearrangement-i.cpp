class Solution {
public:
    string smallestPalindrome(string s) {
        int n = s.size();
        int start = (n+1)/2;
        sort(s.begin(),s.begin()+n/2);
        sort(s.begin()+start,s.end(),greater<char>());
        //reverse(s.begin()+n/2,s.end());
        return s;

        vector<int>freq(26,0);
        string left;
        string right;
        for(char c:s){
            freq[c-'a']++;
        }
        char mid = 0;
        for(int i=0;i<26;i++){
            left.append(freq[i]/2,'a'+i);
            //appends char 'a'+i freq/2 times

            if(freq[i]%2)
                mid = 'a'+i;


        }

        right = left;
        reverse(right.begin(),right.end());

        return left+(mid?string(1,mid):"")+right;
    }
};