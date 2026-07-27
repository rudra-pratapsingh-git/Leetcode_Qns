class tuple{
    int first;
    int second;
    int third;
    public tuple(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n==1 && grid[0][0]==0) return 1;
        if(grid[0][0]==1)return -1;

        Queue<tuple> q = new LinkedList<>();
        int dist[][] = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = (int)1e9;

            }
        }
        dist[0][0] = 1;
        q.add(new tuple(1,0,0));
        while(!q.isEmpty()){
            tuple it = q.poll();
            int dis = it.first;
            int row = it.second;
            int col = it.third;

            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    int nrow = row + i;
                    int ncol = col + j;

                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && 1+dis<dist[nrow][ncol] && grid[nrow][ncol]==0){
                        dist[nrow][ncol] = 1+dis;
                        if(nrow == n-1 && ncol ==n-1){
                            return 1+dis;
                        }
                        q.add(new tuple(1+dis,nrow,ncol));
                    }
                }
            }
        }
        return -1;
    }
}