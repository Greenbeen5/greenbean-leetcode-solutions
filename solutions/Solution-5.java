class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len == 0) return "";
        int start=0,end=1;
        int maxLen = 0;
        boolean[][] dp = new boolean[len][len];
        for(int j = 0;j<len;++j){
            for(int i = 0; i<len; ++i){
                if(i>j) continue;
                if(j==i){
                    dp[i][j] = true;
                }else{
                    if(j - i == 1){
                        dp[i][j] = (s.charAt(i) == s.charAt(j));
                    }else{
                        dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                    }
                }
                if(dp[i][j]){
                    if(maxLen < j-i+1){
                        maxLen = j-i+1;
                        start = i;
                        end = j+1;
                    }
                }
            }
        }
        return s.substring(start,end);
    }
}