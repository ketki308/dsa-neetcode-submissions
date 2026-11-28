class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;
    }
    private void mergesort(int[] map,int i,int j){
        if(i>=j) return;
        int m=(i+j)/2;
        mergesort(map,i,m);
        mergesort(map,m+1,j);
        merge(map,i,m,j);
    }
    private void merge(int[] arr,int i,int m,int j){
        List<Integer> temp=new ArrayList<>();

        int l=i;
        int r=m+1;

        while(l<=m && r<=j){
            if(arr[l]<=arr[r]){
                temp.add(arr[l]);
                l++;
            }else{
                temp.add(arr[r]);
                    r++;
            }
        }

        while(l<=m){
            temp.add(arr[l]);
            l++;
        }

        while(r<=j){
            temp.add(arr[r]);
            r++;
        }

        for(l=i;l<=j;l++){
            arr[l]=temp.get(l-i);
        }
    }
}