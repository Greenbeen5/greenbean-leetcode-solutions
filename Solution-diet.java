class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int left = 0;
        int right = k-1;
        int score = 0;
        int sum = 0;
        for(int i = left;i<=right;++i){
            sum += calories[i];
        }
        while(true){
            if (sum < lower){
                score -= 1;
            }
            else if(sum > upper){
                score += 1;
            }
            else{}
            if(right == calories.length-1){
                break;
            }
            sum -= calories[left++];
            sum += calories[++right];
            
        }
        return score;
    }
}