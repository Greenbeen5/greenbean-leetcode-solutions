class Solution {
    public int countBinarySubstrings(String s) {
        if(s.length() == 1) return 0;
        int last = 0, cur = 1;
        int lastSeg = 0, curSeg = 0;
        int res = 0;
        while(cur<s.length() && s.charAt(cur) == s.charAt(last)) cur++;
        lastSeg = cur - last;
        last = cur;
        while(cur < s.length()){
            if(s.charAt(cur) != s.charAt(last)){
                curSeg = cur - last;
                res += Math.min(curSeg, lastSeg);
                last = cur;
                lastSeg = curSeg;
            }
            cur++;
        }
        res += Math.min(cur-last, lastSeg);

        return res;
    }
}