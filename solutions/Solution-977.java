class Solution {
    public int[] sortedSquares(int[] A) {
        int[] sqr = new int[A.length];
        int left = 0, right = A.length-1, idx = A.length-1;
        while(left <= right){
            if(Math.abs(A[left]) <= Math.abs(A[right])){
                sqr[idx--] = A[right] * A[right];
                right--;
            }else{
                sqr[idx--] = A[left] * A[left];
                left++;
            }
        }
        return sqr;
    }
}