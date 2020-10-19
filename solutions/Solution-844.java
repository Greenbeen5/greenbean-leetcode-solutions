class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] sc = new char[S.length()];
        char[] tc = new char[T.length()];
        int p1 = 0, p2 = 0;
        p1 = fill(S, sc, p1);
        p2 = fill(T, tc, p2);
        if(p1 != p2)return false;
        else{
            for(int i = 0; i<p1; ++i){
                if(sc[i] != tc[i]){
                    return false;
                }
            }
            return true;
        }
    }
    
    private int fill(String s, char[] tar, int idx){
        for(int i = 0; i<s.length(); ++i){
            char cur = s.charAt(i);
            if(cur  == '#'){
                if(idx != 0){
                    idx--;
                }
            }else{
                tar[idx++] = cur;
            }
        }
        return idx;
    }
}