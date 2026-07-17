class Solution {
    private boolean dfsCheck(int node,ArrayList<ArrayList<Integer>> adj,int vis[],int pathVis[],Stack<Integer> st){
        vis[node]=1;
        pathVis[node]=1;

        for(int it: adj.get(node)){
            if(vis[it]==0){
                if(dfsCheck(it,adj,vis,pathVis,st)==true) return true;
            }else if(pathVis[it]==1){
                return true;
            }
        }
        pathVis[node]=0;
        st.push(node);
        return false;

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int arr[] = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<prerequisites.length;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int vis[] = new int[numCourses];
        int pathVis[] = new int[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                if(dfsCheck(i,adj,vis,pathVis,st)==true){
                    return new int[]{};
                }
            }
        }
        int idx =0;
        while(!st.isEmpty()){
            arr[idx++] = st.pop();
        }
        return arr;
    }
}