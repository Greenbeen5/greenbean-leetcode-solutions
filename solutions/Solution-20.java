class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 == 1) return false; // s with odd length will never satisfy the requirements
        Deque<Character> left = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if('(' == ch || '{' == ch || '[' == ch){
                left.addFirst(ch);
            } else if(')' == ch){
                if(left.size() == 0 || left.peek() != '('){
                    return false;
                }else{
                    left.removeFirst();
                }
            } else if('}' == ch){
                if(left.size() == 0 || left.peek() != '{'){
                    return false;
                }else{
                    left.removeFirst();
                }
            } else if(']' == ch){
                if(left.size() == 0 || left.peek() != '['){
                    return false;
                }else{
                    left.removeFirst();
                }
            }
        }
        if(left.size() != 0){
            return false;
        }
        return true;
    }
}