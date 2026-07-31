public class Pair{
    long first;
    int second;

    public Pair(long first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        int m = roads.length;

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int road[]:roads){
            adj.get(road[0]).add(new Pair(road[1],road[2]));
            adj.get(road[1]).add(new Pair(road[0],road[2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->Long.compare(x.first,y.first));
        pq.add(new Pair(0,0));

       

        long dist[] = new long[n];
        long ways[] = new long[n];
        for(int i=0;i<n;i++){
            dist[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }
        ways[0] = 1;
        dist[0] = 0;
        int mod = (int)(1e9+7);

         while(!pq.isEmpty()){
            Pair p = pq.poll();
            long dis = p.first;
            int node = p.second;
            
            if(dis>dist[node]) continue;

            for(Pair edge:adj.get(node)){
                int adjNode = (int)edge.first;
                int edW = edge.second;

                if(edW + dis < dist[adjNode]){
                    dist[adjNode] = edW + dis;
                    ways[adjNode] = ways[node];
                    pq.add(new Pair(edW+dis,adjNode));
                }else if(edW + dis == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;

                }
            }
        }

        return (int)(ways[n-1]%mod);



    }
}