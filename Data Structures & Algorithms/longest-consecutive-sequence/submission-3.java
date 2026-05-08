class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        int longest=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int currnum=num;
                int count=1;

                while(set.contains(currnum+1)){
                    currnum++;
                    count++;
                }
            longest=Math.max(longest,count);

            }

        }
        return longest;
    }
}
