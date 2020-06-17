class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(char[] row : board){
            if(!isValidRow(row)){
                return false;
            }
        }
        for(int i = 0; i<9; i++){
            if(!isValidCol(board, i)){
                return false;
            }
        }
        for(int i = 0; i<9; i+=3){
            for(int j = 0; j<9; j+=3){
                if(!isValidNine(board, i, j)){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValidCol(char[][] board, int col){
        int[] check = new int[10];
        for(int i = 0; i<9; i++){
            int num = board[i][col] - '0';
            if(num < 0){
                continue;
            }
            if(check[num] != 0){
                return false;
            }else{
                check[num] = 1;
            }
        }
        return true;
    }
    
    public boolean isValidNine(char[][] board, int row, int col){
        int[] check = new int[10];
        for(int i = 0; i<3 ;i++){
            for(int j = 0;j<3;j++){
                int num = board[row + i][col + j] - '0';
                if(num < 0){
                    continue;
                }
                if(check[num] != 0){
                    return false;
                }else{
                    check[num] = 1;
                }
            }
        }
        return true;
    }
    
    public boolean isValidRow(char[] row){
        int[] check = new int[10];
        for(char c : row){
            if(c == '.'){
                continue;
            }
            if(check[c-'0'] != 0){
                return false;
            }else{
                check[c-'0'] = 1;
            }
        }
        return true;
    }
}