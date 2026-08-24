class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }

    int findParent(int node){
        if(parent.get(node) == node) return node;

        int ulp = findParent(parent.get(node));
        parent.set(node,ulp);

        return parent.get(node);
    }

    void unionByRank(int u,int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv) return;

        if(rank.get(pu) < rank.get(pv)){
            parent.set(pu,pv);
        }else if(rank.get(pu) > rank.get(pv)){
            parent.set(pv,pu);
        }else{
            parent.set(pv,pu);
            rank.set(pu,rank.get(pu)+1);
        }
    }

    void unionBySize(int u,int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv) return;

        if(size.get(pu) < size.get(pv)){
            parent.set(pu,pv);
            int sizeul = size.get(pu) + size.get(pv);
            size.set(pv,sizeul);
        }else{
            parent.set(pv,pu);
            int sizeul = size.get(pu) + size.get(pv);
            size.set(pu,sizeul);
        }
    }
}


class Solution {
    public int largestIsland(int[][] grid) {

        int n = grid.length;

        DisjointSet ds = new DisjointSet(n*n);

        for(int row = 0;row<n;row++){
            for(int col = 0;col<n;col++){
                if(grid[row][col] == 1){
                    int dr[] = {-1,0,1,0};
                    int dc[] = {0,1,0,-1};

                    for(int ind = 0;ind<4;ind++){
                        int newr = row + dr[ind];
                        int newc = col + dc[ind];

                        if(newr>=0 && newr<n && newc>=0 && newc<n && grid[newr][newc] == 1){
                            int node = row*n + col;
                            int adjNode = newr*n + newc;
                            ds.unionBySize(node,adjNode);
                        }
                    }
                }
            }
        }

        int ans = 0;
        for(int row = 0;row<n;row++){
            for(int col = 0;col<n;col++){
                if(grid[row][col] == 1) continue;

                Set<Integer> component = new HashSet<>();

                int dr[] = {-1,0,1,0};
                int dc[] = {0,1,0,-1};

                for(int ind = 0;ind<4;ind++){
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];

                    if(newr>=0 && newr<n && newc>=0 && newc<n && grid[newr][newc] ==1){
                        int adjNode = newr*n + newc;

                        int root = ds.findParent(adjNode);
                        component.add(root);

                    }
                }

                int currentSize = 1;

                for(Integer it: component){
                    currentSize += ds.size.get(it);

                }
                ans = Math.max(ans,currentSize);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    int node = i*n + j;
                    ans = Math.max(ans,ds.size.get(ds.findParent(node)));
                }
            }
        }

        return ans;
    }
}