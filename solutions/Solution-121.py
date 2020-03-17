class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        max_profit = 0
        cur_lowest = 0
        for i in range(len(prices)-1):
            if prices[i+1] < prices[i]:
                if prices[i+1] < prices[cur_lowest]:
                    cur_lowest = i+1
            else:
                max_profit = max(max_profit,prices[i+1] - prices[cur_lowest])
        return max_profit