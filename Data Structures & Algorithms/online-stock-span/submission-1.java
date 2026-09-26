class StockSpanner {
    private Stack<int[]> st;
    public StockSpanner() {
        st=new Stack<>();
    }
    
    public int next(int price) {
        int spam=1;
        while(!st.isEmpty() && st.peek()[0]<price){
            spam+=st.pop()[1];
        }
        st.push(new int[]{price,spam});

        return spam;
    }

}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */