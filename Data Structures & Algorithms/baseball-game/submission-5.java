class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();
        for(String op:operations){
            if(op.equals("+")){
                int first=st.pop();
                int res=first+st.peek();
                st.push(first);
                st.push(res);
            }else if(op.equals("C")){
                st.pop();
            }else if(op.equals("D")){
                st.push(2*st.peek());
            }
            else{
                st.push(Integer.parseInt(op));
            }
        }
        int out=0;
        for(int i=st.size()-1;i>=0;i--){
            out+=st.pop();
        }
        return out;
    }
}