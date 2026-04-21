class Solution {
    public int maxProfit(int[] prices) {
        int res=0,freq=prices[0];
        for(int i=0;i<prices.length;i++){
            freq=Math.min(freq,prices[i]);
            res=Math.max(res,prices[i]-freq);
        }
        return res;
    }
}
