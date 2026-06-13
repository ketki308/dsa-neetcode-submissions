class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        int freq=prices[0];
        for(int price:prices){
            freq=Math.min(freq,price);
            res=Math.max(res,price-freq);
        }
        return res;
    }
}
