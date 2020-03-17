class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] distribution = new int[num_people];
        int candiesLeft = candies;
        int curCandies = 1;
        while(candiesLeft > 0){
            for(int i = 0;i<num_people;++i){
                if(candiesLeft <= curCandies){
                    distribution[i] += candiesLeft;
                    candiesLeft = 0;
                    break;
                }
                else{
                    distribution[i] += curCandies;
                    candiesLeft -= curCandies;
                    curCandies += 1;
                }
            }
        }
        return distribution;
    }
}