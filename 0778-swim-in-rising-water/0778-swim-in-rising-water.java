class Tuple{
    int time;
    int row;
    int col;

    public Tuple(int time,int row,int col){
        this.time = time;
        this.row = row;
        this.col = col;
    }
}

class Solution {
    public int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)->Integer.compare(x.time,y.time));

        int vis[][] = new int[n][n];

        pq.add(new Tuple(grid[0][0],0,0));

        while(!pq.isEmpty()){

            Tuple it = pq.poll();
            int currTime = it.time;
            int r = it.row;
            int c = it.col;

            if(r==n-1 && c==n-1) return currTime;

            int dr[] = {-1,0,1,0};
            int dc[] = {0,1,0,-1};

            for(int i=0;i<4;i++){
                int nrow = r + dr[i];
                int ncol = c + dc[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && vis[nrow][ncol] ==0){
                    vis[nrow][ncol] = 1;
                    pq.add(new Tuple(Math.max(grid[nrow][ncol],currTime),nrow,ncol));
                }
            }
        }

        return -1;
        
    }
}