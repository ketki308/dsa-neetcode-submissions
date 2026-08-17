class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidates1=0;
        int candidates2=0;
        int count1=0;
        int count2=0;

        for(int num:nums){
            if(num==candidates1){
                count1++;
            }else if(num==candidates2){
                count2++;
            }else if(count1==0){
                candidates1=num;
                count1=1;
            }else if(count2==0){
                candidates2=num;
                count2=1;
            }else{
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;
        for(int num:nums){
            if(num==candidates1){count1++;}
            else if(num==candidates2){count2++;}
        }

        List<Integer> res=new ArrayList<>();
        if(count1>nums.length/3){
            res.add(candidates1);
        }if(count2>nums.length/3){
            res.add(candidates2);
        }

        return res;
    }
}