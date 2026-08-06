class Solution {

    public boolean productOfDigits(int num,int t){
        int product = 1;

        while(num!=0){
            int rem = num%10;
            product = product*rem;
            num /= 10;
        }

        if(product%t ==0) return true;
        return false;
    }
    public int smallestNumber(int n, int t) {
        
        
        for(int i=0;i<10;i++){
            if(productOfDigits(n+i,t)==true){
                return n+i;
            }
        }
        return -1;
    }
}