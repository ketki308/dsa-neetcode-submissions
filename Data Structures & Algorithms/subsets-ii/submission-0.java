class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>(),res);
        return res;
    }
    private void backtrack(int[] nums,int i,List<Integer> ds,List<List<Integer>> res){
        if(i==nums.length){
            res.add(new ArrayList<>(ds));
            return;
        }

        
            ds.add(nums[i]);
            backtrack(nums,i+1,ds,res);
            ds.remove(ds.size()-1);
        
        while(i+1<nums.length && nums[i]==nums[i+1]){
            i++;
        }
        backtrack(nums,i+1,ds,res);
    }
}
