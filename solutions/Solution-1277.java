class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int cnt = 0;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;++i){
            int val;
            if((val = matrix[i][0]) == 1){
                cnt++;
            }
            dp[i][0] = val;
        }
        for(int j=0;j<n;++j){
            int val;
            if((val = matrix[0][j]) == 1){
                cnt++;
            }
            dp[0][j] = val;
        }
        if(matrix[0][0] == 1) cnt--; // 会多数一个
        for(int i = 1; i<m; ++i){
            for(int j = 1; j<n; ++j){
                if(matrix[i][j] == 0){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j],dp[i][j-1])) + 1;
                    cnt += dp[i][j];
                }
            }
        }
        return cnt;
    }
}