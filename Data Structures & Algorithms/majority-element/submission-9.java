class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int candidates=0;

        for(int num:nums){
            if(count==0){
                candidates=num;
                count++;
            }
            else if(candidates==num){
                count++;
            }
            else if(candidates==0){
                candidates=num;
            }
            else{
                count=0;
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