class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] road=new int[1001];
        for(int[] trip:trips){
            int passengers=trip[0];
            int from=trip[1];
            int to=trip[2];

            road[from]+=passengers;
            road[to]-=passengers;
        }
        int currpassengers=0;
        for(int i=0;i<1001;i++){
            currpassengers+=road[i];

            if(currpassengers>capacity){
                return false;
            }
        }
        return true;
    }
}