class Solution {
    //SC- O(3N)
    //TC - O(V+E)
    private:
        bool dfsCheck(int node,vector<vector<int>>& adj,vector<int>& vis,vector<int>& pathVis,vector<int>& check){
            vis[node]=1;
            pathVis[node]=1;
            check[node]=0;
            for(auto it: adj[node]){
                if(vis[it]==0){
                    if(dfsCheck(it,adj,vis,pathVis,check)==true){check[node]=0;return true;}
                }else if(pathVis[it]==1){check[node]=0;
                        return true;
                    }
            }

            pathVis[node]=0;
            check[node]=1;
            return false;
        }
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n  = graph.size();
        vector<int> vis(n,0);
        vector<int> pathVis(n,0);
        vector<vector<int>> adj(n);
        vector<int> check(n);
        for(int i=0;i<n;i++){
            for(auto it:graph[i]){
                adj[i].push_back(it);
            }
        }

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfsCheck(i,adj,vis,pathVis,check);
            }
        }
        vector<int> ans;
        for(int i=0;i<n;i++){
            if(check[i]==1) ans.push_back(i);
        }

        return ans;
    }
};