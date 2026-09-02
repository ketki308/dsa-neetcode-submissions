class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int maj1=0,maj2=0;
        int count1=0,count2=0;

        for(int num:nums){
            if(count1==0){
                maj1=num;
                count1=1;
            }else if(count2==0){
                maj2=num;
                count2=1;
            }
            else if(num==maj1){
                count1++;
            }else if(num==maj2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int num:nums){
            if(maj1==num){
                count1++;
            }
            else if(maj2==num){
                count2++;
            }
        }
        List<Integer> res=new ArrayList<>();
        if(count1>nums.length/3){
            res.add(maj1);
        }
        if(count2>nums.length/3){
            res.add(maj2);
        }

        return res;
    }
}