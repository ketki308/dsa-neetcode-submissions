class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        int freq=prices[0];
        for(int i=1;i<prices.length;i++){
            freq=Math.min(freq,prices[i]);
            res=Math.max(res,prices[i]-freq);
        }
        return res;
    }
}
