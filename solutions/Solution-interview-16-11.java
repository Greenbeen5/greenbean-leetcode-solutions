class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k == 0) return new int[0];
        int diff = longer - shorter;
        int[] res;
        if(diff > 0){
            res = new int[k+1];
            res[0] = shorter * k;
            for(int i = 1; i<=k; ++i){
                res[i] = res[i-1] + diff;
            }
        }else{
            res = new int[1];
            res[0] = shorter * k;
        }

        return res;
    }
}