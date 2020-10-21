class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int sum = 0;
        for(int i = n-1; i>=0; i--){
            int cur = sum;
            for(int j = i+1; j<=n-1; j++){
                cur += satisfaction[j];
            }
            cur += satisfaction[i];
            if(cur < 0 || cur < sum){
                return sum;
            }else{
                sum = cur;
            }
        }
        return sum;
    }
}