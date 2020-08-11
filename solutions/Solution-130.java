class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        if(rows == 0) return;
        int cols = board[0].length;
        for(int i = 0; i<cols; ++i){
            dfs(board, 0, i); // first row
            dfs(board,rows-1,i); // last row
        }
        for(int i = 0; i<rows; ++i){
            dfs(board,i,0); // first column
            dfs(board,i,cols-1); // last column
        }
        for(int i = 0; i<rows; ++i){
            for(int j = 0; j<cols; ++j){
                if(board[i][j] == 'M'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int row, int col){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        if(board[row][col] == 'O'){
            board[row][col] = 'M'; // Marked
            dfs(board, row - 1, col);
            dfs(board, row + 1, col);
            dfs(board, row, col + 1);
            dfs(board, row, col - 1);
        }
    }
}