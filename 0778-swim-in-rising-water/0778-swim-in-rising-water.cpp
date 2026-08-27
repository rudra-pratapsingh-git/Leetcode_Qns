class Solution {
public:
    int swimInWater(vector<vector<int>>& grid) {
        int n = grid.size();

        using Node = pair<int,pair<int,int>>;
        priority_queue<
                    Node,vector<Node>,greater<Node> > pq;

        vector<vector<int>> vis(n,vector<int>(n,0));

        pq.push({grid[0][0],{0,0}});

        while(!pq.empty()){
            int currTime = pq.top().first;
            int row = pq.top().second.first;
            int col = pq.top().second.second;

            pq.pop();

            if(row == n-1 && col == n-1) return currTime;

            int dr[] = {-1,0,1,0};
            int dc[] = {0,1,0,-1};

            for(int i=0;i<4;i++){
                int nrow = row + dr[i];
                int ncol = col + dc[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && !vis[nrow][ncol]){
                    vis[nrow][ncol] = 1;
                    pq.push({max(grid[nrow][ncol],currTime),{nrow,ncol}});
                }
            }
        }

        return -1;

    }
};