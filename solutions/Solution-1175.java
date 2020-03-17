class Solution {
    public int numPrimeArrangements(int n) {
        long modder=1000000007L;
        if(n!=1){
            long ans = 0L;
            int[] primeTable = new int[]{2,3,5,7,11,
                                         13,17,19,23,29,
                                         31,37,41,43,47,
                                         53,59,61,67,71,
                                         73,79,83,89,97,101};
            int primeCount=0;
            for(int i = 0;i<26;i++){
                if(primeTable[i] <= n){
                    primeCount = i+1; 
                }
                else{
                    break;
                }
            }

            long primeP=1L,compP=1L;
            for(int i = primeCount;i>=1;i--){
                primeP *= i;
                primeP %= modder;
            }
            for(int i = n-primeCount;i>=1;i--){
                compP *= i;
                compP %= modder;
            }
            ans = (compP * primeP) % modder;
            return (int)ans;
        }
        else{
            return 1;
        }
    }
}