class Solution {
    public int largestPerimeter(int[] A) {
        if(A.length < 3) return 0;
        Arrays.sort(A);
        for(int i = A.length-1; i>=2; --i){
            int a = A[i];
            int b = A[i-1];
            int c = A[i-2];
            if(a < b + c) return a+b+c;
        }
        return 0;
    }
}