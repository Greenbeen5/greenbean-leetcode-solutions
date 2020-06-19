class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0)return true;
        char[] charArr = new char[s.length()];
        int ptr = 0;
        for(char ch : s.toCharArray()){
            if(isAlpha(ch) || isNum(ch)){
                charArr[ptr++] = Character.toLowerCase(ch);
            }
        }
        for(int i = 0, j = ptr - 1; i < j; i++, j--){
            if(charArr[i] != charArr[j]){
                return false;
            }
        }
        return true;
    }
    
    public boolean isAlpha(char c){
        int lower = c - 'a';
        int upper = c - 'A';
        if(lower >= 0 && lower <= 25 || upper >= 0 && upper <= 25){
            return true;
        }
        return false;
    }
    
    public boolean isNum(char c){
        int num = c - '0';
        if(num >= 0 && num <= 9){
            return true;
        }
        return false;
    }
}