class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        queue<pair<int,pair<int,int>>> q;
        int n = grid.size();
        if(n==1 && grid[0][0]==0)return 1;
        if(grid[0][0]==1)return -1;

        vector<vector<int>> dist(n,vector<int>(n,1e9));
        dist[0][0] = 1;
        q.push({1,{0,0}});
        int drow[] = {-1,-1,-1,0,1,1,1,0};
        int dcol[] = {-1,0,1,1,1,0,-1,-1};

        while(!q.empty()){
            auto it = q.front();
            q.pop();
            int dis = it.first;
            int row = it.second.first;
            int col = it.second.second;

            for(int i=0;i<8;i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && 1+dis<dist[nrow][ncol] && grid[nrow][ncol]==0){
                    dist[nrow][ncol] = 1+dis;
                    if(nrow==n-1 && ncol==n-1) return 1+dis;
                    q.push({1+dis,{nrow,ncol}});
                }
            }
        }
        return -1;

    }
};