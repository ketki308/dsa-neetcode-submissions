class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int n=0;
        for(int num:nums){
            if(count==0){
                n=num;
            }
            if(num==n){
                count++;
            }
            else{
                count--;
            }
        }
        count=0;
        for(int num:nums){
            if(num==n){
                count++;
            }
            else{
                count--;
            }
        }
        return n;
    }
}