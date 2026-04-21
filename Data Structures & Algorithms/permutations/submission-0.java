class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        boolean[] used=new boolean[nums.length];
        backtrack(nums,used,new ArrayList<>(),res);
        return res;
    }
    private void backtrack(int[] nums,boolean[] used,List<Integer> ds,List<List<Integer>> res){
        if(ds.size()==nums.length){
            res.add(new ArrayList<>(ds));
            return ;
        }

        for(int i=0;i<nums.length;i++){

            if(used[i]) continue;

            if(i>0 && nums[i]==nums[i-1] && !used[i-1]) continue;

            used[i]=true;
            ds.add(nums[i]);
            backtrack(nums,used,ds,res);

            ds.remove(ds.size()-1);
            used[i]=false;
        }
    }
}
