class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] nums = new int[n];
        int j = 0;
        for(int i = 0;i<n;i++){
            int cur = s.charAt(i) - '0';
            if(cur == 0){
                if(j == 0){
                    return 0;
                }else if(nums[j-1] != 1 && nums[j-1] != 2){
                        return 0;
                }else{
                    nums[j-1] = 0;
                }
            }else{
                nums[j++] = cur;
            }
        }
        int[] dp = new int[j];
        dp[0] = 1;
        for(int i = 1;i<j;i++){
            if(nums[i] != 0 && nums[i-1] != 0 && nums[i-1] * 10 + nums[i] <= 26){
                if(i < 2){
                    dp[i] = i+1;
                }else{
                    dp[i] = dp[i-1] + dp[i-2];
                }
                
            }else{
                dp[i] = dp[i-1];
            }
        }

        return dp[j-1];
    }
}