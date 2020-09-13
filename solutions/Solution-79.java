class Solution {
    boolean[][] used;
    public boolean exist(char[][] board, String word) {
        boolean res = false;
        int m = board.length;
        if(m == 0) return false;
        int n = board[0].length;
        used = new boolean[m][n];
        char[] chs = word.toCharArray();
        for(int i = 0; i<m; ++i){
            for(int j = 0; j<n; ++j){
                if(board[i][j] == chs[0]){
                    if(chs.length == 1) return true;
                    used[i][j] = true;
                    res =  dfs(board, i - 1, j, chs, 1) || 
                        dfs(board, i + 1, j, chs, 1) ||
                        dfs(board, i, j - 1, chs, 1) ||
                        dfs(board, i, j + 1, chs, 1);
                    if(res) return true;
                    else{
                        used[i][j] = false;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] b, int i, int j, char[] chs, int k){
        if(i < 0 || i >= b.length || j < 0 || j >= b[0].length || used[i][j] == true) return false;
        else{
            if(b[i][j] == chs[k]){
                if(k == chs.length - 1) return true;
                used[i][j] = true;
                if(dfs(b, i - 1, j, chs, k+1) || 
                        dfs(b, i + 1, j, chs, k+1) ||
                        dfs(b, i, j - 1, chs, k+1) ||
                        dfs(b, i, j + 1, chs, k+1)) return true;
                else{
                    used[i][j] = false;
                    return false;
                }
            }
        }
        return false;
    }
}