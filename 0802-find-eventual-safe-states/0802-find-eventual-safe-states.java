class Solution {
    private boolean dfsCheck(int node,ArrayList<ArrayList<Integer>> adj, int[] vis,int[] pathVis,int[] check){
        vis[node]=1;
        pathVis[node]=1;
        check[node]=0;
        for(int it: adj.get(node)){
            if(vis[it]==0){
                if(dfsCheck(it,adj,vis,pathVis,check)==true) return true;
            }else if(pathVis[it]==1) return true;
        }

        pathVis[node]=0;
        check[node]=1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        int[] pathVis = new int[n];
        int[] check = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int it:graph[i]){
                adj.get(i).add(it);
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i]==0) {
                dfsCheck(i,adj,vis,pathVis,check);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(check[i]==1){
                ans.add(i);
            }
        }

        return ans;
    }
}