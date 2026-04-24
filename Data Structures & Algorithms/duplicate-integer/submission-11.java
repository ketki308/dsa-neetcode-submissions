class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> res=new HashSet<>();
        for(int num:nums){
                if(!res.add(num)) return true;
        }
        return false;

    }
}