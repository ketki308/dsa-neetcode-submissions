class Solution {
    public int majorityElement(int[] nums) {
        int maj=0;
        int count=0;
        for(int num:nums){
            if(count==0){
                maj=num;
                count=1;
            }
            else if(num==maj){
                count++;
            }else{
                count--;
            }
        }

        count=0;
        for(int num:nums){
            if(maj==num){
                count++;
            }else{
                count--;
            }
        }

        return maj;
    }
}