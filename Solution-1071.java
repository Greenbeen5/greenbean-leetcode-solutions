class Solution {
    public String gcdOfStrings(String str1, String str2) {
        Stack<String> prefixes = new Stack<>();
        for(int i = 0;i<Math.min(str1.length(),str2.length());i++){
            if(str1.charAt(i) == str2.charAt(i)){
                prefixes.push(str1.substring(0,i+1));
            }else{
                break;
            }
        }
        while(!prefixes.isEmpty()){
            String p = prefixes.pop();
            if(tryDivide(str1,p)&&tryDivide(str2,p)){
                return p;
            }
        }
        return "";
    }
    
    private boolean tryDivide(String str,String pre){
        if(str.length() % pre.length() != 0){
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(pre);
        while(sb.length() <= str.length()){
            if(str.equals(sb.toString())){
                return true;
            }
            sb.append(pre);
        }
        return false;
    }
}