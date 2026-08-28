class Solution {
    public int numRescueBoats(int[] people, int limit) {

        int n = people.length;
        Arrays.sort(people);

        int boats = 0;
        int l = 0;
        int r = n-1;

        while(l<=r){

            if(people[l] + people[r] <= limit){
                l++;
                r--;
            }else{
                r--;
            }
            boats++;
        } 
        return boats;
    }
}