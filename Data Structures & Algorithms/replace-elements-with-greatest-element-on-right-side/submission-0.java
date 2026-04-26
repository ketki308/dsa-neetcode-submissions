class Solution {
    public int[] replaceElements(int[] arr) {
        int maxright=-1;
        for(int i=arr.length-1;i>=0;i--){
            int current=arr[i];
            arr[i]=maxright;
            maxright=Math.max(maxright,current);
        }
        return arr;
    }
}