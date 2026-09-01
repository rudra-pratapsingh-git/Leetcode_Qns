class Pair{
    int dest;
    int color;
    public Pair(int dest,int color){
        this.dest = dest;
        this.color = color;
    }
}

class Tuple{
    int node,dist,lastColor;

    public Tuple(int node,int lastColor,int dist){
        this.node = node;
        this.lastColor = lastColor;
        this.dist = dist;
    }
}

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        // 0-> red, 1-> blue
        for(int edge[]:redEdges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(new Pair(v,0));

        }

        for(int edge[]:blueEdges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(new Pair(v,1));
        }

        int vis[][] = new int[n][2];
        //0->red,1->blue
        int dist[] = new int[n];
        Arrays.fill(dist,-1);
        dist[0] = 0;

        Queue<Tuple> q = new LinkedList<>();

        q.add(new Tuple(0,-1,0));

        while(!q.isEmpty()){
            Tuple it = q.poll();
            int node = it.node;
            int lastColor = it.lastColor;
            int distance = it.dist;

            for(Pair edge:adj.get(node)){
                int color = edge.color;
                int adjNode = edge.dest;

                if(color == lastColor){
                    continue;
                }

                if(vis[adjNode][color] == 1){
                    continue;
                }
                vis[adjNode][color] = 1;

                if(dist[adjNode] == -1){
                    dist[adjNode] = distance+1;
                }

                q.add(new Tuple(adjNode,color,distance+1));
            }
        }

        return dist;
    }
}