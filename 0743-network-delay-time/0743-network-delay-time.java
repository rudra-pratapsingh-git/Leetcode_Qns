class Pair{
    int first;
    int second;

    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time:times){
            adj.get(time[0]).add(new Pair(time[1],time[2]));
        }

        int dist[] = new int[n+1];
        Arrays.fill(dist,(int)1e9);
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->Integer.compare(x.first,y.first));

        pq.add(new Pair(0,k));
        dist[k] = 0;

        while(!pq.isEmpty()){
            Pair p = pq.poll();

            int dis = p.first;
            int node = p.second;

            if(dis>dist[node])continue;

            for(Pair it : adj.get(node)){
                int edW = it.second;
                int adjNode = it.first;

                if(dis+edW<dist[adjNode]){
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair(dist[adjNode],adjNode));
                }
            }
        }

        int minTime = 0;
        for(int i=1;i<=n;i++){
            if(dist[i]==1e9) return -1;
            minTime = Math.max(minTime,dist[i]);
        }

        return minTime;

    }
}