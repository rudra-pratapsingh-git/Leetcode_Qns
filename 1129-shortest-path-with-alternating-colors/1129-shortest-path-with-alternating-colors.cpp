class Solution {
public:
    vector<int> shortestAlternatingPaths(int n, vector<vector<int>>& redEdges, vector<vector<int>>& blueEdges) {
        vector<vector<pair<int,int>>> adj(n);

        // 0 -> red
        // 1-> blue

        for(auto edge: redEdges){
            int u = edge[0];
            int v = edge[1];

            adj[u].push_back({v,0});
        }

        for(auto edge: blueEdges){
            int u = edge[0];
            int v = edge[1];

            adj[u].push_back({v,1});
        }

        vector<vector<int>> vis (n,vector<int> (2,0));

        vector<int> dist(n,-1);
        dist[0] = 0;
        queue<pair<int,pair<int,int>>> q;
        q.push({0,{-1,0}});
        // node,lastcolor,dist

        while(!q.empty()){
            int node = q.front().first;
            int lastColor = q.front().second.first;
            int distance = q.front().second.second;

            q.pop();

            for(auto it: adj[node]){
                int adjNode = it.first;
                int color = it.second;

                if(color == lastColor) continue;

                if(vis[adjNode][color] == 1) continue;

                int newDist = distance + 1;
                if(dist[adjNode] == -1){
                    dist[adjNode] = newDist;
                }

                vis[adjNode][color] = 1;
                q.push({adjNode,{color,newDist}});
            }
        }

        return dist;
    }
};