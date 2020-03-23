class Solution {
    public int minIncrementForUnique(int[] A) {
        if(A.length == 0 || A.length == 1){
            return 0;
        }
        int moves = 0;
        Arrays.sort(A);
        for(int i = 1; i<A.length;i++){
            if(A[i] <= A[i-1]){
                moves += A[i-1] - A[i] + 1;
                A[i] = A[i-1] + 1;
            }
        }
        return moves;
    }
}