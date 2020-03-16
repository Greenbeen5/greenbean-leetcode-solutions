class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0,right = 1;
        int ans = 1;
        boolean flag = false;
        if(s.length() == 0){
            return 0;
        }
        while(right <= s.length() - 1){
            for(int i = left; i<right ; i++){
                if(s.charAt(i) == s.charAt(right)){
                    //ans = ans < (right - left + 1) ? (right - left + 1) : ans;
                    left = i + 1;
                    flag = true;
                    break;
                }
            }
            if(!flag){
                ans = ans < (right - left + 1) ? (right - left + 1) : ans;
            }
            flag = false;
            right++;
        }
        return ans;
    }
}