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

        void unionByRank(int u,int v){
            int pu = findParent(u);
            int pv = findParent(v);

            if(pu == pv) return;

            if(rank[pu] < rank[pv]){
                parent[pu] = pv;
            }else if(rank[pu] > rank[pv]){
                parent[pv] = pu;
            }else{
                parent[pv] = pu;
                rank[pu]++;
            }
        }

        void unionBySize(int u,int v){
            int pu = findParent(u);
            int pv = findParent(v);

            if(pu == pv) return;

            if(size[pu]<size[pv]){
                parent[pu] = pv;
                size[pv] += size[pu];
            }else{
                parent[pv]  = pu;
                size[pu] += size[pv];
            }
        }
};

class Solution {
public:
    int makeConnected(int n, vector<vector<int>>& connections) {
        
        DisjointSet ds(n);
        int cntExtra = 0;

        for(auto edge: connections){
            int u = edge[0];
            int v = edge[1];

            if(ds.findParent(u) == ds.findParent(v)){
                cntExtra++;
            }else{
                ds.unionByRank(u,v);
            }
        }

        int connectedComp = 0;

        for(int i=0;i<n;i++){
            if(ds.parent[i] == i) connectedComp++;
        }

        int ans = connectedComp-1;

        if(cntExtra >= ans) return ans;

        return -1;
    }
};