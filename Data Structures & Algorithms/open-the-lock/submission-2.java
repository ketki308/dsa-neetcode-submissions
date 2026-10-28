class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set=new HashSet<>(Arrays.asList(deadends));
        Queue<String> q=new LinkedList<>();
        if(set.contains("0000")) return -1;

        q.offer("0000");
        set.add("0000");

        int turns=0;
        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                String lock=q.poll();

                if(lock.equals(target)) return turns;

                for(String next:children(lock)){
                    if(!set.contains(next)){
                        q.offer(next);
                        set.add(next);
                    }
                }
            }
            turns++;
        }
        return -1;
    }
    private List<String> children(String lock){
        List<String> res=new ArrayList<>();

        for(int i=0;i<4;i++){
            char[] arr=lock.toCharArray();
            arr[i]=(char)(((arr[i]-'0'+1)%10)+'0');
            res.add(new String(arr));

            arr=lock.toCharArray();
            arr[i]=(char)(((arr[i]-'0'-1+10)%10)+'0');
            res.add(new String(arr));
        }
        return res;
    }
}