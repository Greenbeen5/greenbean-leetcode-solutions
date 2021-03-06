class Solution {
    public boolean validMountainArray(int[] A) {
        if(A.length < 3) return false;
        boolean flag = false;
        if(A[0] >= A[1]) return false;
        if(A[A.length - 2] <= A[A.length - 1]) return false;
        for(int i = 0; i<A.length - 1; ++i){
            if(A[i] == A[i+1])return false;
            if(!flag){
                if(A[i] > A[i+1]) flag = true;
            }else if(A[i] < A[i+1]){
                return false;
            }
        }
        return true;
    }
}