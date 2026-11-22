class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();

        for(int num:nums){
            set.add(num);
        }

        int maxcount=0;

        for(int num:set){
            int count=0;
            int number=num;

            while(set.contains(number)){
                count++;
                number+=1;
            }

            maxcount=Math.max(count,maxcount);
        }
        return maxcount;
    }
}
