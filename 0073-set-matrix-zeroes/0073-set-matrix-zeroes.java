class Solution {
    public void setZeroes(int[][] matrix) {
        //optimal approach ->without extra space
        int col0 = 1;
        //col[m]->{0} -> mat[0][j] = 0 + col = 0
        //row[n]->{0}->mat[i][0] = 0 

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    // mark its row marker as zero
                    matrix[i][0] = 0;

                    if(j!=0){
                        //mark its col marker as zero
                        matrix[0][j] = 0;
                    }else {
                        //mark col0 (column should be zero) as zero
                        col0 = 0;
                    }
                }
            }
        }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]!=0){
                    //check if its row,col marker is zero
                    if(matrix[i][0] ==0 || matrix[0][j]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }

        //now go for 0th row
        if(matrix[0][0]==0){
            for(int j=0;j<matrix[0].length;j++){
                matrix[0][j] = 0;
            }
        }

        //go for 0th column
        if(col0 ==0){
            for(int i=0;i<matrix.length;i++){
                matrix[i][0] = 0;
            }
        }

    }
}