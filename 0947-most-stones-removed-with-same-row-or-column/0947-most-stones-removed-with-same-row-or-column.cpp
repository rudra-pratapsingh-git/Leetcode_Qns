class DisjointSet{
    public:
        vector<int> parent,rank,size;

        DisjointSet(int n){
            parent.resize(n+1);
            rank.resize(n+1);
            size.resize(n+1);

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

        void unionByRank(int u,int v){
            int pu = findParent(u);
            int pv = findParent(v);

            if(pu == pv) return ;

            if(rank[pu] < rank[pv]){
                parent[pu] = pv;
            }else if(rank[pu] > rank[pv]){
                parent[pv] = pu;
            }else{
                parent[pv] = pu;
                rank[pu]++;
            }
        }
};


class Solution {
public:
    int removeStones(vector<vector<int>>& stones) {
        int n =stones.size();
        int maxRow = 0;
        int maxCol = 0;

        for(auto it: stones){
            maxRow = max(maxRow,it[0]);
            maxCol = max(maxCol,it[1]);
        }

        DisjointSet ds(maxRow+maxCol+2);

        unordered_map<int,int> map;

        for(auto it: stones){
            int nodeRow = it[0];
            int nodeCol = it[1] + maxRow+1;

            ds.unionBySize(nodeRow,nodeCol);

            map[nodeRow] = 1;
            map[nodeCol] = 1;
        }

        int cnt = 0;
        for(auto it: map){
            if(ds.findParent(it.first) == it.first){
                cnt++;
            }
        }

        return n-cnt;
    }
};

