class Solution {
    public int maxSumDivThree(int[] nums) {
        int dp[][] = new int[nums.length][3];
        // for(int i = 0;i<nums.length;i++){
        //     for(int j = 0;j<3;j++){
        //         dp[i][j] = 0;
        //     }
        // }
        for(int i = nums.length -1;i>=0;i--){
            int k = nums[i];
            if(i == nums.length -1){
                if(k % 3 == 0){
                    dp[i][0] = k;
                }else if(k % 3 == 1){
                    dp[i][1] = k;
                }else{
                    dp[i][2] = k;
                }
            }else{
                if(k % 3 == 0){
                    dp[i][0] = dp[i+1][0] + k;
                    if(dp[i+1][1] != 0)
                        dp[i][1] = dp[i+1][1] + k;
                    if(dp[i+1][2] != 0)
                        dp[i][2] = dp[i+1][2] + k;
                }else if(k % 3 == 1){
                    dp[i][0] = Math.max(dp[i+1][2] + k, dp[i+1][0]);
                    dp[i][1] = Math.max(dp[i+1][0] + k, dp[i+1][1]);
                    dp[i][2] = Math.max(dp[i+1][1] + k, dp[i+1][2]);
                }else{
                    dp[i][0] = Math.max(dp[i+1][1] + k, dp[i+1][0]);
                    dp[i][1] = Math.max(dp[i+1][2] + k, dp[i+1][1]);
                    dp[i][2] = Math.max(dp[i+1][0] + k, dp[i+1][2]);
                }
            }
        }
        return dp[0][0];
    }
}