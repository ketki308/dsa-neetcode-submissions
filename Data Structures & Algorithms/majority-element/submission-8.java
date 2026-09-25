class Solution {
    public int majorityElement(int[] nums) {
        int candidates=0;
        int count=0;
        for(int num:nums){
            if(count==0){
                candidates=num;
                count=1;
            }else if(num==candidates){
                count++;
            }else{
                count--;
            }
        }
        
        count=0;
        for(int num:nums){
            if(candidates==num){
                count++;
            }
        }

        return candidates;
    }
}