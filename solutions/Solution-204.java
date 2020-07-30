class Solution {
    public int countPrimes(int n) {
        if(n <= 2) return 0;
        int res = 1;
        boolean[] nums = new boolean[n]; // boolean[] is faster than int[], why?
        // true-notPrime, false-prime
        for(int i = 3; i<n; i+=2){
            if(!nums[i]){ // perhaps it is because true/false judge is faster than ==0 judge
                ++res;
                for(int j = i; (long)i*j < (long)n; j+=2){
                    nums[i*j] = true;
                }
            }
        }
        return res;
    }
}