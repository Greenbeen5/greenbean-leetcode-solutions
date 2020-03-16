class Solution {
    public String compressString(String S) {
        StringBuilder sb = new StringBuilder();
        if(S.length()<=1){
            return S;
        }
        char last = S.charAt(0);
        char cur = 'a';
        int cnt = 1;
        for(int i = 1;i<S.length();i++){
            cur = S.charAt(i);
            if(cur == last){
                cnt++;
            }else{
                sb.append(last);
                sb.append(cnt);
                cnt = 1;
                last = cur;
            }
        }
        sb.append(last);
        sb.append(cnt);
        if(sb.length() >= S.length()){
            return S;
        }else{
            return sb.toString();
        }
    }
}