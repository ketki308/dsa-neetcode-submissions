class Solution {
    public int maxProfit(int[] prices) {
        int freq=prices[0];
        int max=0;
        for (int i=0;i<prices.length;i++){
            freq=Math.min(freq,prices[i]);
            max=Math.max(max,prices[i]-freq);
        }
        return max;
    }
}
