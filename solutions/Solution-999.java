class Solution {
    public int numRookCaptures(char[][] board) {
        //1. find the rook
        int ri=0,rj=0,ans=0;
        for(int i = 0;i<8;i++){
            for(int j = 0;j<8;j++){
                if(board[i][j]=='R'){
                    ri = i;
                    rj = j;
                    break;
                }
            }
        }
        //2. find the pawns
        for(int i = ri-1;i>0;i--){
            if(board[i][rj] == 'B'){
                break;
            }else if(board[i][rj] == 'p'){
                ++ans;
                break;
            }
        }
        for(int i = ri+1;i<8;i++){
            if(board[i][rj] == 'B'){
                break;
            }else if(board[i][rj] == 'p'){
                ++ans;
                break;
            }
        }
        for(int j = rj-1;j>0;j--){
            if(board[ri][j] == 'B'){
                break;
            }else if(board[ri][j] == 'p'){
                ++ans;
                break;
            }
        }
        for(int j = rj+1;j<8;j++){
            if(board[ri][j] == 'B'){
                break;
            }else if(board[ri][j] == 'p'){
                ++ans;
                break;
            }
        }
        
        return ans;
    }
}