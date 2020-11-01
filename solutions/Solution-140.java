/*
    Follow the solution of Problem 139 to judge if s can be divided,
    then use backtrack to perform wordBreak. Trie and memo can also
    be used to solve this problem. When revising, consider reading 
    the solution page at: 
    https://leetcode-cn.com/problems/word-break-ii/solution/
*/
class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if(!canBreak(s,wordDict)){
            return ans;
        }
        int len = s.length();
        boolean[][] inDict = new boolean[len + 1][len + 1];
        int[][] idx = new int[len + 1][len + 1];
        List<Integer> indices = new ArrayList<>();
        for(int i = 1; i <= len; ++i){
            int index;
            if((index = wordDict.indexOf(s.substring(0,i))) != -1){
                inDict[0][i] = true;
                idx[0][i] = index;
            }
        }
        for(int i = 1; i <= len; ++i){
            if(inDict[0][i]){
                if(i == len){
                    ans.add(s);
                }else{
                    indices.add(idx[0][i]);
                    backtrack(wordDict, inDict, idx, s, i, indices);
                    indices.remove(indices.size() - 1);
                }
            }
        }
        return ans;
    }
    
    private void backtrack(List<String> dict, boolean[][] inDict, int[][] idx, String s, int i, List<Integer> ind){
        int len = s.length();
        int index = -1;
        for(int j = i+1; j<=len; ++j){
            if(inDict[i][j] || (index = dict.indexOf(s.substring(i,j))) != -1){
                inDict[i][j] = true;
                idx[i][j] = index == -1 ? idx[i][j] : index; 
                ind.add(idx[i][j]);
                if(j != len){
                    backtrack(dict, inDict, idx, s, j, ind);
                }else{
                    StringBuilder sb = new StringBuilder();
                    for(int k = 0; k<ind.size(); ++k){
                        if(k != 0){
                            sb.append(' ');
                        }
                        sb.append(dict.get(ind.get(k)));
                    }
                    ans.add(sb.toString());
                }
                ind.remove(ind.size() - 1);
            }
        }
    }
    public boolean canBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] dp = new boolean[len];
        int maxDictWordLength = 0;
        for(String word : wordDict){
            maxDictWordLength = Math.max(maxDictWordLength, word.length());
        }
        for(int i = 0; i < len; ++i){
            for(int j = (i - maxDictWordLength) > 0 ? (i - maxDictWordLength) : 0; j < i; ++j){
                if(dp[j]){
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