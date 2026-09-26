class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st=new Stack<>();

        for(String op:operations){
            if(op.equals("+")){
                int first=st.pop();
                int second=st.pop();
                int res=first+second;
                st.push(second);
                st.push(first);
                st.push(res);
            }else if(op.equals("C")){
                st.pop();
            }else if(op.equals("D")){
                int first=st.pop();
                int res=first*2;
                st.push(first);
                st.push(res);
            }else{
                st.push(Integer.parseInt(op));
            }
        }

        int sum=0;
        for(int num:st){
            sum+=num;
        }

        return sum;
    }
}