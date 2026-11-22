class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1=0;
        int count2=0;
        int candi1=0;
        int candi2=0;
        for(int num:nums){
            if(count1==0){
                candi1=num;
                count1=1;
            }else if(count2==0){
                candi2=num;
                count2=1;
            }else if(num==candi1){
                count1++;
            }else if(num==candi2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }

        count1=0;
        count2=0;

        for(int num:nums){
            if(num==candi1){
                count1++;
            }
            else if(num==candi2){
                count2++;
            }
        }

        List<Integer> res=new ArrayList<>();
        int n=nums.length;
        if((n/3)<count1){
            res.add(candi1);
        }
        if((n/3)<count2){
            res.add(candi2);
        }

        return res;
    }
}