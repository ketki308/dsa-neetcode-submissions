class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int maxcount=0;
        for(int num:nums){
            set.add(num);
        }

        for(int num:set){
            if(!set.contains(num-1)){
                int count=1;
                int number=num;

                while(set.contains(number+1)){
                    count++;
                    number=number+1;
                }
                maxcount=Math.max(maxcount,count);
            }
        }
        return maxcount;
    }
}
