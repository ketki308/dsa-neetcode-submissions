class Solution {
    public int maxProfit(int[] prices) {
        int num=prices[0];
        int ans=0;
        for(int price:prices){
            num=Math.min(num,preice);
            ans=Math.max(res,price-num);
        }
        return ans;
    }
}
