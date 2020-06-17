class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int maxScore = 0;
        int lastBest = A[0]-1; // Record the best site in A[0:i-1]
        for(int i = 1; i<A.length;++i){
            maxScore = Math.max(lastBest + A[i], maxScore);
            // the following if-else is a bit faster the Math.max
            lastBest -= 1;
            if(lastBest < A[i] - 1){
                lastBest = A[i] - 1;
            }
        }
        return maxScore;
    }
}