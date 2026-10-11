class Solution {
    public int romanToInt(String s) {
        int[] map=new int[256];

        map['I']=1; map['V']=5; map['X']=10; map['L']=50; map['C']=100;map['D']=500;
        map['M']=1000;

        int res=0;
        for(int i=0;i<s.length()-1;i++){
            int curr=map[s.charAt(i)];
            int next=map[s.charAt(i+1)];
            res+=curr<next?-curr:curr;
        }
        return res+map[s.charAt(s.length()-1)];
    }
}
