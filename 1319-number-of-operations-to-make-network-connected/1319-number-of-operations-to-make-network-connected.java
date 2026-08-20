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
        if(node == parent.get(node)) return node;

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
        }else if(rank.get(pu)> rank.get(pv)){
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
            size.set(pv,size.get(pu)+size.get(pv));
        }else{
            parent.set(pv,pu);
            size.set(pu,size.get(pu) + size.get(pv));
        }
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds = new DisjointSet(n);

        int cntExtraEdge = 0;

        for(int[] edge: connections){
            int u = edge[0];
            int v = edge[1];

            if(ds.findParent(u) == ds.findParent(v)){
                cntExtraEdge++;
            }else{
                ds.unionBySize(u,v);
            }
        }

        int connectedComp = 0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i) == i) connectedComp++;
        }
        int ans = connectedComp-1;

        if(cntExtraEdge >= ans) return ans;
        return -1;
    }
}