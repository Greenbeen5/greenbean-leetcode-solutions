class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len]; // remember the judged substring
        int maxDictWordLength = 0; 
        for(String word : wordDict){
            maxDictWordLength = Math.max(maxDictWordLength, word.length());
        }
        for(int i = 0; i < len; ++i){
            for(int j = (i - maxDictWordLength) > 0 ? (i - maxDictWordLength) : 0; j < i; ++j){ // to reduce the times of inner for-loop, start from (i-maxDictWordLength) if possible
                if(dp[j] == true){
                    if(wordDict.contains(s.substring(j+1, i+1))){
                        dp[i] = true;
                        break;
                    }
                }
            }
            if(!dp[i]){
                dp[i] = wordDict.contains(s.substring(0, i+1));
            }
        }
        return dp[len-1];
    }
    

}