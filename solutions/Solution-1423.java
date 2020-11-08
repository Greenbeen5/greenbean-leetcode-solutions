class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int score = 0;
        int maxS = 0;
        int len = cardPoints.length;
        for(int i = 0; i < k; ++i){
            score += cardPoints[i];
        }
        maxS = score;
        for(int i = 0; i < k; ++i){
            score -= cardPoints[k - i - 1];
            score += cardPoints[len - 1 - i];
            maxS = Math.max(maxS, score);
        }
        return maxS;
    }
}