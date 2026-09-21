class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;   
    }
    private void mergesort(int[] nums,int left,int right){
        if(left>=right) return;
        int mid=(left+right)/2;
        mergesort(nums,left,mid);
        mergesort(nums,mid+1,right);
        merge(nums,left,mid,right);
    }
    private void merge(int[] nums,int left,int mid,int right){
        List<Integer> temp=new ArrayList<>();
        int i=left;
        int j=mid+1;
        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                temp.add(nums[i]);
                i++;
            }
            else{
                temp.add(nums[j]);
                j++;
            }
        }
        while(i<=mid){
            temp.add(nums[i]);
            i++;
        }
        while(j<=right){
            temp.add(nums[j]);
            j++;
        }
        for(i=left;i<=right;i++){
            nums[i]=temp.get(i-left);
        }
    }
}