class Solution {
    public int maxProfit(int[] prices) {
        boolean bought = false;
        int buy=0, sell=0, sum=0;
        for(int i = 0; i<prices.length-1; ++i){
            if(!bought){
                if(prices[i+1] >= prices[i]){
                    buy = prices[i];
                    bought = true;
                }
            }else{
                if(prices[i+1] <= prices[i]){
                    sell = prices[i];
                    sum += sell - buy;
                    bought = false;
                }
            }
        }
        if(bought){
            sum += prices[prices.length-1] - buy;
        }
        return sum;
    }
}