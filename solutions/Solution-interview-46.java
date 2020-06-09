class Solution {
    public int translateNum(int num) {
        int[] dp = new int[11];
        String str = String.valueOf(num);
        dp[0] = 1;
        for(int i = 1; i<str.length(); ++i){
            char last = str.charAt(i-1);
            char cur = str.charAt(i);
            if(last == '1'){
                if(i >= 2){
                    dp[i] = dp[i-1]  + dp[i-2];
                }else{
                    dp[i] = dp[i-1]  + 1;
                }
                continue;
            }
            if(last == '2'){
                if(cur-'0' <= 5){
                    if(i >= 2){
                        dp[i] = dp[i-1]  + dp[i-2];
                    }else{
                        dp[i] = dp[i-1]  + 1;
                    }
                    continue;
                }
            }
            dp[i] = dp[i-1];
        }
        return dp[str.length()-1];
    }
}