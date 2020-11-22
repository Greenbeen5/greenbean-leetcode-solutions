class Solution {
    public int countSubstrings(String s) {
        if(s == null) return 0;
        
        int len = s.length();
        if(len <= 1) return len;
        boolean[][] dp = new boolean[len][len];
        int cnt = 0;
        for(int i = 0; i<len; ++i){
            dp[i][i] = true;
            cnt++;
        }
        for(int i = 1; i < len; ++i){
            for(int j = len-1; j-i >= 0; j--){
                if(s.charAt(j-i) == s.charAt(j)){
                    if(i == 1){
                        dp[j-i][j] = true;
                        cnt++;
                    }else{
                        dp[j-i][j] = dp[j-i+1][j-1];
                        if(dp[j-i][j]) cnt++;
                    }
                }else{
                    dp[j-i][j] = false;
                }
            }
        }
        return cnt;
    }
}