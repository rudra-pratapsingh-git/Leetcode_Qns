class Solution {
public:

    int productDigits(int x){
        int ans = 1;
        while(x!=0){
            int rem = x%10;
            ans *= rem;
            x/=10;
        }
        return ans;
    }
    int smallestNumber(int n, int t) {
        
        for(int i=n;i<=n+10;i++){
            if(productDigits(i)%t==0) return i;
        }
        return 0;
    }
};