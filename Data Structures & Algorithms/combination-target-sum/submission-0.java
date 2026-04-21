class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res= new ArrayList<>();
      List<Integer> ds=new ArrayList<>();
      sum(nums,target,0,res,ds);
      return res;
    } 
    private void sum(int[] arr,int target, int ind,List<List<Integer>> res,List<Integer> ds){
        if(ind==arr.length){
            if(target==0){
             res.add(new ArrayList<>(ds));
        }
        return ;}
        if(arr[ind]<=target){
            ds.add(arr[ind]);
            sum(arr,target-arr[ind],ind,res,ds);
            ds.remove(ds.size()-1);
        }
        sum(arr,target,ind+1,res,ds);
    }
}
