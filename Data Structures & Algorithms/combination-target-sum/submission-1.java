class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        backtrack(0,nums,target,ds,res);
        return res;
    }
    private void backtrack(int index,int[] nums,int target,List<Integer> ds,List<List<Integer>> res){
        if(index==nums.length){
            if(target==0){
                res.add(new ArrayList<>(ds));
            }
            return;
        }

        if(nums[index]<=target){
            ds.add(nums[index]);
            backtrack(index,nums,target-nums[index],ds,res);
            ds.remove(ds.size()-1);
        }
        backtrack(index+1,nums,target,ds,res);
    }
}
