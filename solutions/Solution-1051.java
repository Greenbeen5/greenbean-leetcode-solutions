class Solution {
    public int heightChecker(int[] heights) {
        int diff = 0;
        int[] tmp = heights.clone();
        Arrays.sort(heights);
        for(int i = 0;i<heights.length;++i){
            if(tmp[i] != heights[i]){
                diff++;
            }
        }
        return diff;
    }
}