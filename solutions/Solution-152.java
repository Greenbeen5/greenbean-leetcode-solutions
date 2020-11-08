class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = Math.max(nums[0], 0);
        dp[0][1] = Math.min(nums[0], 0);
        int prod = dp[0][0];
        for(int i = 1; i<nums.length; ++i){
            if(nums[i] >= 0){
                dp[i][0] = Math.max(dp[i-1][0] * nums[i], nums[i]);
                dp[i][1] = dp[i-1][1] * nums[i];
            }else{
                dp[i][0] = dp[i-1][1] * nums[i];
                dp[i][1] = Math.min(dp[i-1][0] * nums[i], nums[i]);
            }
            prod = Math.max(prod, dp[i][0]);
        }
        return prod;
    }
}