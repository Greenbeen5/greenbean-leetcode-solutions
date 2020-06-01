class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>(candies.length);
        int maxCandies = 0;
        for(int i = 0;i<candies.length;++i){
            maxCandies = Math.max(maxCandies,candies[i]);
            ans.add(true);
        }
        for(int i = 0;i<candies.length;++i){
            if(maxCandies > candies[i] + extraCandies){
                ans.set(i,false);
            }
        }
        return ans;
    }
}