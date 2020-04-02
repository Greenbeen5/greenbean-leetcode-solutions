class Solution {
    public void gameOfLife(int[][] board) {
        int[][] nextBoard = new int[board.length][board[0].length];
        // Copy the board
        int m = board.length;
        int n = board[0].length;
        for(int i = 0;i<m;++i){
            for(int j = 0;j<n;++j){
                int count = 0;
                if(i > 0){
                    count += board[i-1][j];
                    if(j > 0){
                        count += board[i-1][j-1];
                    }
                    if(j < n-1){
                        count += board[i-1][j+1];
                    }
                }
                if(i < m-1){
                    count += board[i+1][j];
                    if(j < n-1){
                        count += board[i+1][j+1];
                    }
                    if(j > 0){
                        count += board[i+1][j-1];
                    }
                }
                if(j > 0){
                    count += board[i][j-1];
                }
                if(j < n-1){
                    count += board[i][j+1];
                }                
                if(board[i][j]==0 && count == 3){
                    nextBoard[i][j] = 1;
                }else if(board[i][j] == 1){
                    if(count < 2){
                        nextBoard[i][j] = 0;
                    }else if(count < 4){
                        nextBoard[i][j] = 1;
                    }else{
                        nextBoard[i][j] = 0;
                    }
                }
            }
        }
        for(int i = 0;i<board.length;++i){
            for(int j = 0;j<board[0].length;++j){
                board[i][j] = nextBoard[i][j];
            }
        }
    }
}