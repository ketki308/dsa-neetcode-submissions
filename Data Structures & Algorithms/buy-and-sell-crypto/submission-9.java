class Solution {
    public int maxProfit(int[] prices) {
        int num=prices[0];
        int ans=0;
        for(int price:prices){
            num=Math.min(num,price);
            ans=Math.max(ans,price-num);
        }
        return ans;
    }
}
