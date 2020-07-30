class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapping = new HashMap<>();
        for(int i = 0; i<s.length(); ++i){
            char key = s.charAt(i);
            char val = t.charAt(i);
            if(mapping.containsKey(key)){
                if(mapping.get(key) != val){
                    return false;
                }
            }else if(mapping.containsValue(val)){
                return false;
            }else{
                mapping.put(key,val);
            }
        }
        return true;
    }
}