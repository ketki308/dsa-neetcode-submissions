class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();

        for(String t:tokens){
            if(t.equals("+")){
                int first=st.pop();
                int second=st.pop();
                st.push(first+second);
            }else if(t.equals("-")){
                int first=st.pop();
                int second=st.pop();
                st.push(second-first);
            }else if(t.equals("*")){
                int first=st.pop();
                int second=st.pop();
                st.push(first*second);
            }else if(t.equals("/")){
                int first=st.pop();
                int second=st.pop();
                st.push(second/first);
            }else{
                st.push(Integer.parseInt(t));
            }
        }
        return st.peek();
    }
}
