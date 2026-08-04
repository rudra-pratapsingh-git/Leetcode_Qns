class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<vector<pair<int,int>>> adj(n+1);

        for(auto time:times){
            adj[time[0]].push_back({time[1],time[2]});
        }


        vector<int> dist(n+1,1e9);
        dist[k] = 0;
        priority_queue<pair<int,int>,
                        vector<pair<int,int>>,
                        greater<pair<int,int>>> pq;

        pq.push({0,k});

        while(!pq.empty()){
            auto it = pq.top();
            pq.pop();
            int dis = it.first;
            int node = it.second;

            if(dis>dist[node]) continue;

            for(auto iter:adj[node]){
                int adjNode = iter.first;
                int edW = iter.second;

                if(dis+edW < dist[adjNode]){
                    dist[adjNode] = edW + dis;
                    pq.push({edW+dis,adjNode});
                }
            }
        }

        int minTime = 0;
        for(int i=1;i<=n;i++){
            if(dist[i]==1e9) return -1;
            minTime = max(minTime,dist[i]);
        }

        return minTime;
            
    }
};