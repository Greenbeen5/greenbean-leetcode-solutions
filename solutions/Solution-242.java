class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())return false;
        int[] origin = new int[26];
        int[] anagram = new int[26];
        for(int i = 0; i<s.length(); ++i){
            origin[s.charAt(i)-'a']++;
            anagram[t.charAt(i)-'a']++;
        }
        for(int i = 0; i<26; ++i){
            if(origin[i] != anagram[i]) return false;
        }
        return true;
    }
}