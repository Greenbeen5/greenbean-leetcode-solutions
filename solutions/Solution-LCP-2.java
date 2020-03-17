class Solution {
    public int[] fraction(int[] cont) {
        int[] cur = new int[2];
        cur[0] = 1;
        cur[1] = cont[cont.length-1];
        int tmp;
        for(int i = cont.length-2;i>=0;i--){
            tmp = cur[1] * cont[i];
            cur[0] += tmp;
            
            tmp = cur[1];
            cur[1] = cur[0];
            cur[0] = tmp;
        }
        tmp = cur[1];
        cur[1] = cur[0];
        cur[0] = tmp;
        return cur;
    }
}