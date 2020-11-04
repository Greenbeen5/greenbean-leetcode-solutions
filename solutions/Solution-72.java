class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dist = new int[len1+1][len2+1];
        for(int i = 0; i<=len1; ++i){
            dist[i][0] = i;
        }
        for(int i = 0; i<=len2; ++i){
            dist[0][i] = i;
        }
        int change = 0;
        for(int i = 1; i<=len1; ++i){
            for(int j = 1; j<=len2; ++j){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    change = 0;
                }else{
                    change = 1;
                }
                dist[i][j] = Math.min(dist[i-1][j] + 1, Math.min(dist[i][j-1] + 1, dist[i-1][j-1] + change));
            }
        }
        return dist[len1][len2];
    }
}