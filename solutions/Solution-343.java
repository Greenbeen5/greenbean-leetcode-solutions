class Solution {
    public int integerBreak(int n) {
        if(n<=1) return 0;
        if(n==2) return 1;
        if(n==3) return 2;
        if(n==4) return 4;
        int count3 = n/3;
        int res = 1;
        for(int i = 0; i<count3; ++i){
                res *= 3;
        }
        if(n % 3 == 1){
            res /= 3;
            res *= 4;
        }else if(n % 3 == 2){
            res *= 2;
        }
        return res;
    }
}