class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        /*
            使用大小为2*n的数组来存储中间过程，
            其中一行记录上一层的结果，另一行在当前层记录每个位置的
            最短路径，如果该位置在左右两端，那么直接和上一层两端的结果相加即可，
            如果不是，那么按以下规则求出最短路径：
                min(dp[(i+1)%2][j-1],dp[(i+1)%2][j]) + triangle.get(i).get(j)
            数组的两行交错进行存储和计算，用i%2标记上一层，(i+1)%2标记当前层
        */
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1;i<n;i++){
            for(int j = 0;j<=i;j++){
                if(j==0){
                    dp[i%2][j] = dp[(i+1)%2][0] + triangle.get(i).get(0);
                }else if(j < i){
                    dp[i%2][j] = min(dp[(i+1)%2][j-1],dp[(i+1)%2][j]) + triangle.get(i).get(j);
                }else{
                    dp[i%2][j] = dp[(i+1)%2][i-1] + triangle.get(i).get(i);
                }
                
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0;i<n;i++){
            ans = min(dp[(n+1)%2][i] , ans);
        }
        return ans;
    }
    
    private int min(int a,int b){
        return a<b?a:b;
    }
}