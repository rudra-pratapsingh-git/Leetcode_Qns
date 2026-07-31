class Solution {
    // TC - O(ElogV)
public:
    int countPaths(int n, vector<vector<int>>& roads) {
        vector<vector<pair<int,int>>> adj(n);
        int m = roads.size();
        for(auto it:roads){
            adj[it[0]].push_back({it[1],it[2]});
            adj[it[1]].push_back({it[0],it[2]});
        }

        priority_queue<pair<long long,int>,
                        vector<pair<long long,int>>,
                        greater<pair<long long,int>>> pq;

        vector<long long> dist(n,1e18),ways(n,0);
        dist[0] = 0;
        ways[0] = 1;
        int mod = (int)(1e9+7);
        pq.push({0,0});

        while(!pq.empty()){
            long long dis = pq.top().first;
            int node = pq.top().second;
            pq.pop();

            if(dis>dist[node]) continue;

            for(auto it: adj[node]){
                int edW = it.second;
                int adjNode = it.first;

                if(dis+edW < dist[adjNode]){
                    dist[adjNode] = edW + dis;
                    pq.push({edW+dis,adjNode});
                    ways[adjNode] = ways[node];
                }else if(edW+dis == dist[adjNode]){
                    ways[adjNode] =(ways[adjNode] + ways[node])%mod;
                }
            }
        }
        return ways[n-1]%mod;                
    }
};