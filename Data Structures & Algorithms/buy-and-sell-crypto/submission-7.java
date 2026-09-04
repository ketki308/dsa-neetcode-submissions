class Solution {
    public int maxProfit(int[] prices) {
        int num=prices[0];
        int res=0;
        for(int price:prices){
            num=Math.min(num,price);
            res=Math.max(res,price-num);
        }
        return res;
    }
}
