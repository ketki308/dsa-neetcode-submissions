class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res=new ArrayList<>();
        backtrack(candidates,target,0,res,new ArrayList<>());
        return res;
    }
    private void backtrack(int[] nums,int target,int index,List<List<Integer>> res,List<Integer> ds){

        if(target==0){
            res.add(new ArrayList<>(ds));
            return ;
        }

        for(int i=index;i<nums.length;i++){
            if(i>index && nums[i]==nums[i-1]) continue;

            if(nums[index]>target) break;
            ds.add(nums[i]);
            backtrack(nums,target-nums[i],i+1,res,ds);
            ds.remove(ds.size()-1);
        }
    }
}
