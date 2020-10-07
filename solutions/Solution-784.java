class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String S) {
        int letters = 0;
        for(int i = 0; i<S.length(); ++i){
            if(Character.isLetter(S.charAt(i))){
                letters++;
            }
        }
        if(letters == 0){
            res.add(S);
        }else{
            int[] pos = new int[letters];
            StringBuilder sb = new StringBuilder(S);
            for(int i = 0,cnt = 0; i<S.length(); ++i){
                if(Character.isLetter(S.charAt(i))){
                    pos[cnt++] = i;
                    sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
                }
            }
            permute(sb, pos, 0);
        }
        return res;
    }
    
    private void permute(StringBuilder sb, int[] pos, int idx){
        if(idx < pos.length){
            sb.setCharAt(pos[idx], Character.toLowerCase(sb.charAt(pos[idx])));
            permute(sb, pos, idx+1);
            sb.setCharAt(pos[idx], Character.toUpperCase(sb.charAt(pos[idx])));
            permute(sb, pos, idx+1);
        }else{
            res.add(sb.toString());
        }
    }
}