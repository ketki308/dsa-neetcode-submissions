class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int maj=0;
        for(int num:nums){
            if(count==0){
                maj=num;
            }
            if(maj==num){
                count++;
            }else{
                count--;
            }
        }

        count=0;
        for(int num:nums){
            if(maj==num){
                count++;
            }
        }

        return maj;
    }
}