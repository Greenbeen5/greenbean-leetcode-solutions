class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if(A.length < 3) return 0;
        if(A.length == 3){
            if(A[2] - A[1] == A[1] - A[0])return 1;
            else return 0;
        }
        int len = A.length;
        int[] diff = new int[len-1];
        for(int i = 0; i<len-1; ++i){
            diff[i] = A[i+1] - A[i];
        }
        int cur = 1;
        int res = 0;
        for(int i = 1; i<len-1; ++i){
            if(diff[i] == diff[i-1]){
                cur++;
            }else{
                if(cur > 1) res += (cur-1)*cur >> 1;
                cur = 1;
            }
        }
        if(cur > 1) res += (cur-1)*cur >> 1;
        return res;
    }
}