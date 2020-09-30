class Solution {
    public int minSteps(int n) {
        if(n <= 1) return 0;
        if(n == 2) return 2;
        int res = 0;
        for(int i = 2; i<=n; ++i){
            if(isPrime(i)){
                while(n % i == 0){
                    res += i;
                    n /= i;
                }
            }
        }
        return res;
    }
    
    private boolean isPrime(int num){
        int sqr = (int)Math.sqrt(num);
        if(num == 1) return false;
        for(int i = 2; i <= sqr; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}