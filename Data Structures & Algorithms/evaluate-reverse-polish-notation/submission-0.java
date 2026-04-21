class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();

        for(String c:tokens){
            if(c.equals("+")){
                st.push(st.pop()+st.pop());
            }else if(c.equals("-")){
                int first=st.pop();
                int second=st.pop();
                st.push(second-first);
            }
            else if(c.equals("*")){
                st.push(st.pop()*st.pop());
            }else if(c.equals("/")){
                int first=st.pop();
                int second=st.pop();
                st.push(second/first);
            }
            else {
                st.push(Integer.parseInt(c));
            }
        }
        return st.peek();
    }
}
