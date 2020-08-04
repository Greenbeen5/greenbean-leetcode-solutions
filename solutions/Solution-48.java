class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0; i<n; ++i){
            for(int j = i+1; j<n; ++j){
                flip(matrix, i, j);
            }
        }
        for(int i = 0; i<n/2; ++i){
            mirror(matrix, i);
        }
    }
    
    public void flip(int[][] matrix, int row, int col){
        int tmp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = tmp;
    }
    
    public void mirror(int[][] matrix,int col){
        for(int i = 0; i<matrix.length; ++i){
            int tmp = matrix[i][col];
            matrix[i][col] = matrix[i][matrix.length - 1 - col];
            matrix[i][matrix.length - 1 - col] = tmp;
        }
    }
}