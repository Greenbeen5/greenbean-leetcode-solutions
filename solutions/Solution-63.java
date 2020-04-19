class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        boolean flg = true;
        for(int i = 0;i<m;i++){
            if(flg && obstacleGrid[i][0]==0){
                dp[i][0] = 1;
            }else if (obstacleGrid[i][0] == 1){
                dp[i][0] = 0;
                flg = false;
            }else{
                dp[i][0] = 0;
            }
        }
        flg = true;
        for(int j = 0;j<n;j++){
            if(flg && obstacleGrid[0][j]==0){
                dp[0][j] = 1;
            }else if (obstacleGrid[0][j] == 1){
                dp[0][j] = 0;
                flg = false;
            }else{
                dp[0][j] = 0;
            }
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i-1][j]+dp[i][j-1] : 0;
            }
        }
        return dp[m-1][n-1];
    }
}