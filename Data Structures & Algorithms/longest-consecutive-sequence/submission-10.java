class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();

        for(int num:nums){
            set.add(num);
        }

        int maxcount=0;

        for(int num:set){
            int count=1;
            int number=num;

            while(set.contains(number+1)){
                count++;
                number+=1;
            }

            maxcount=Math.max(count,maxcount);
        }
        return maxcount;
    }
}
