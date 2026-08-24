class DisjointSet{
    public:
        vector<int> parent,size,rank;

        DisjointSet(int n){
            parent.resize(n+1);
            size.resize(n+1);
            rank.resize(n+1);

            for(int i=0;i<=n;i++){
                parent[i] = i;
                rank[i] = 0;
                size[i] = 1;
            }
        }

        int findParent(int node){
            if(node == parent[node]) return node;

            return parent[node] = findParent(parent[node]);
        }

        void unionByRank(int u,int v){
            int pu = findParent(u);
            int pv = findParent(v);

            if(pu == pv) return;

            if(rank[pu]< rank[pv]){
                parent[pu] = pv;
            }else if(rank[pu] > rank[pv]){
                parent[pv] = pu;
            }else{
                parent[pv] = pu;
                rank[pu]+=1;
            }
        }

        void unionBySize(int u,int v){
            int pu = findParent(u);
            int pv = findParent(v);

            if(pu == pv) return;

            if(size[pu] < size[pv]){
                parent[pu] = pv;
                size[pv] += size[pu];
            }else{
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }


};
class Solution {
private:
    bool isValid(int newr,int newc,int n){
        return newr>=0 && newr<n && newc>=0 && newc<n ;
    }
public:
    int largestIsland(vector<vector<int>>& grid) {
        
        int n = grid.size();
        DisjointSet ds(n*n);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    int dr[] = {-1,0,1,0};
                    int dc[] = {0,1,0,-1};

                    for(int k = 0;k<4;k++){
                        int newrow = i+dr[k];
                        int newcol = j + dc[k];

                        if(isValid(newrow,newcol,n) && grid[newrow][newcol] == 1){
                            int node = i*n + j;
                            int adjNode = newrow*n + newcol;

                            ds.unionBySize(node,adjNode);
                        }
                    }
                }
            }
        }

        int ans = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) continue;

                set<int> components;
                int currentSize = 1;

                int dr[] = {-1,0,1,0};
                int dc[] = {0,1,0,-1};
                int size = 1;

                for(int k = 0;k<4;k++){
                    int newr = i + dr[k];
                    int newc = j + dc[k];

                    if(isValid(newr,newc,n) && grid[newr][newc] == 1){
                        int adjNode = newr*n + newc;

                        int root = ds.findParent(adjNode);
                        components.insert(root);
                    }
                }

                for(auto it: components){
                    currentSize += ds.size[it];
                }
                ans = max(ans,currentSize);

            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int node = i*n + j;

                ans = max(ans,ds.size[ds.findParent(node)]);
            }
        }

        return ans;


    }
};