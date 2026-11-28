class Solution {
    public int majorityElement(int[] nums) {
        int candi=0;
        int count=0;

        for(int num:nums){
            if(count==0){
                candi=num;
                count++;
            }else if(candi==num){
                count++;
            }else{
                count--;
            }
        }

        count=0;
        for(int num:nums){
            if(num==candi){
                count++;
            }
        }

        return candi;
    }
}