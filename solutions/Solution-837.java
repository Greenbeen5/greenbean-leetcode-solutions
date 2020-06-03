class Solution {
    public double new21Game(int N, int K, int W) {
        int maxSum = K-1 + W; // 最大的抽牌结果
        double[] pos = new double[maxSum+1];
        double curWinrate = 0.0;
        for(int i = maxSum;i>=K;i--){
            if(i > N){
                pos[i] = 0.0;
            }else{
                pos[i] = 1.0;
            }
            curWinrate += pos[i]; // 累计在i+w位置的成功率，w为偏置量，取值[1,W]
        }
        for(int i = K-1;i>=0;i--){
            pos[i] = curWinrate / W; // Σ(在位置i+w的成功率)*(到达i+w位置的概率，因为等概率抽牌所以为1/W)
            curWinrate = curWinrate - pos[i+W] + pos[i]; // 滑动窗口
        }
        
        return pos[0];
    }
}