class Solution {
    public String decodeString(String s) {
        Stack<Integer> countstack=new Stack<>();
        Stack<String> stringstack=new Stack<>();
        String curr="";
        int num=0;

        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
            num=num*10+(c-'0');
            }
            else if(c=='['){
                countstack.push(num);
                stringstack.push(curr);
                num=0;
                curr="";
            }
            else if(c==']'){
                int count=countstack.pop();
                String prev=stringstack.pop();

                StringBuilder temp=new StringBuilder(prev);

                for(int i=0;i<count;i++){
                    temp.append(curr);
                    
                }
                curr=temp.toString();
            }
            else{
                curr+=c;
            }
    }
    return curr;
    }
}