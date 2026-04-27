class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;

        Map<Integer,Integer> map=new TreeMap<>();
        for(int card:hand){
            map.put(card,map.getOrDefault(card,0)+1);
        }

        for(int x:map.keySet()){
            int freq=map.get(x);


            if(freq>0){
                for(int i=0;i<groupSize;i++){
                    int curr=x+i;

                    if(map.getOrDefault(curr,0)<freq){
                        return false;
                    }
                    map.put(curr,map.get(curr)-freq);
                }
            }
        }
        return true;
    }
}
