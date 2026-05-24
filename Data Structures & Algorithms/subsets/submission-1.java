class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        backtrack(nums,0,res,ds);
        return res;
    }
    private void backtrack(int[] nums,int num,List<List<Integer>> res,List<Integer> ds ){
        res.add(new ArrayList<>(ds));

        for(int i=num;i<nums.length;i++){
           ds.add(nums[i]);
           backtrack(nums,i+1,res,ds);
           ds.remove(ds.size()-1);
        }
    }
}
