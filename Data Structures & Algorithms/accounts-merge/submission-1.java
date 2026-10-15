class Solution {
    Map<String,Integer> emailIdx=new HashMap<>();
    List<String> emails=new ArrayList<>();
    Map<Integer,Integer> emailToAcc=new HashMap<>();
    boolean[] visited;
    List<List<Integer>> adj;
    Map<Integer,List<String>> emailGroup=new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        int m=0;

        for(int i=0;i<n;i++){
            List<String> account=accounts.get(i);
            for(int j=1;j<account.size();j++){
                String email=account.get(j);
                if(!emailIdx.containsKey(email)){
                    emails.add(email);
                    emailIdx.put(email,m);
                    emailToAcc.put(m,i);
                    m++;
                }
            }
        }

        adj=new ArrayList<>();
        for(int i=0;i<m;i++){
            adj.add(new ArrayList<>());
        }
        for(List<String> account:accounts){
            for(int j=2;j<account.size();j++){
                int id1=emailIdx.get(account.get(j));
                int id2=emailIdx.get(account.get(j-1));
                adj.get(id1).add(id2);
                adj.get(id2).add(id1);
            }
        }
        visited=new boolean[m];

        for(int i=0;i<m;i++){
            if(!visited[i]){
                int accId=emailToAcc.get(i);
                emailGroup.putIfAbsent(accId,new ArrayList<>());
                dfs(i,accId);
            }
        }
        List<List<String>> res=new ArrayList<>();
        for(int i:emailGroup.keySet()){
            List<String> group=emailGroup.get(i);
            Collections.sort(group);
            List<String> merged=new ArrayList<>();
            merged.add(accounts.get(i).get(0));
            merged.addAll(group);
            res.add(merged);
        }
        return res;
    }

    private void dfs(int node,int accId){
        visited[node]=true;
        emailGroup.get(accId).add(emails.get(node));

        for(int neighbor:adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor,accId);
            }
        }
    }
}