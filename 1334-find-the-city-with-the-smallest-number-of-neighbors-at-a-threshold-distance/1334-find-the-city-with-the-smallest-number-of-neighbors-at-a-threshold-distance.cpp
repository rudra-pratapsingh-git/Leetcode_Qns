class Solution {
public:
    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
            vector<vector<pair<int,int>>> adj(n);

            for(auto edge: edges){
                adj[edge[0]].push_back({edge[1],edge[2]});
                adj[edge[1]].push_back({edge[0],edge[2]});
            }

            int cntCity = n;
            int cityNo = -1;

            for(int i=0;i<n;i++){
                vector<int> dist(n,INT_MAX);

                priority_queue<pair<int,int>,
                                vector<pair<int,int>>,
                                greater<pair<int,int>>> pq;

                dist[i] = 0;
                pq.push({0,i});

                while(!pq.empty()){
                    auto it = pq.top();
                    pq.pop();
                    int node = it.second;
                    int dis = it.first;

                    if(dis>dist[node]) continue;

                    for(auto iter: adj[node]){
                        int edW = iter.second;
                        int adjNode = iter.first;

                        if(edW + dis < dist[adjNode]){
                            dist[adjNode] = edW + dis;

                            pq.push({edW+dis,adjNode});
                        }
                    }

                }                
                    int cnt = 0;

                    for(int adjCity = 0;adjCity<n;adjCity++){
                        if(dist[adjCity]<=distanceThreshold){
                            cnt++;
                        }
                    }

                    if(cnt<=cntCity){
                        cntCity = cnt;
                        cityNo = i;
                    }
            }

            return cityNo;




































        // vector<vector<int>>dist(n,vector<int>(n,INT_MAX));

        // for(auto it: edges){
        //     dist[it[0]][it[1]] = it[2];
        //     dist[it[1]][it[0]]  = it[2];
        // }

        // for(int i=0;i<n;i++){
        //     dist[i][i] = 0;
        // }

        // for(int k=0;k<n;k++){
        //     for(int i=0;i<n;i++){
        //         for(int j=0;j<n;j++){
        //             if(dist[i][k]==INT_MAX || dist[j][k]==INT_MAX)continue;

        //             dist[i][j] = min(dist[i][j],dist[i][k]+dist[k][j]);
        //         }
        //     }
        // }

        // int cityNo = -1;
        // int cntCity = n;

        // for(int city=0;city<n;city++){
        //     int cnt = 0;
        //     for(int adjCity = 0;adjCity<n;adjCity++){
        //         if(dist[city][adjCity]<=distanceThreshold){
        //             cnt++;
        //         }
        //     }

        //     if(cnt<=cntCity){
        //         cntCity = cnt;
        //         cityNo = city;
        //     }
        // }

        // return cityNo;
    }
};