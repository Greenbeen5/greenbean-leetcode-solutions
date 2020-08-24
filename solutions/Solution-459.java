class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int i = 1; i <= s.length() / 2; ++i){
            if(s.length() % i == 0){
                StringBuilder concat = new StringBuilder();
                String sub = s.substring(0,i);
                while(concat.length() < s.length()) concat.append(sub.toString());
                if(concat.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}