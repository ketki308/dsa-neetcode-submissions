class Solution {
    public int[] sortArray(int[] nums) {
        mergesort(nums,0,nums.length-1);
        return nums;
    }
    private void mergesort(int[] arr,int l,int r){
        if(l>=r) return ;
        int m=(l+r)/2;
        mergesort(arr,l,m);
        mergesort(arr,m+1,r);
        merge(arr,l,m,r);
    }
    private void merge(int[] arr,int l,int m,int r){
        List<Integer> temp=new ArrayList<>();

        int i=l;
        int j=m+1;

        while(i<=m && j<=r){
            if(arr[i]<=arr[j]){
                temp.add(arr[i]);
                i++;
            }else{
                temp.add(arr[j]);
                j++;
            }
        }

        while(i<=m){
            temp.add(arr[i]);
            i++;
        }

        while(j<=r){
            temp.add(arr[j]);
            j++;
        }

        for(i=l;i<=r;i++){
            arr[i]=temp.get(i-l);
        }
    }
}