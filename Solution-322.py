class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        if amount == 0:
            return 0
        coin_set = set(coins)
        dp = []
        for i in range(0,amount + 1):
            dp.append(-1)
        for i in range(1,amount+1):
            if i in coin_set:
                dp[i] = 1
            for j in coin_set:
                if dp[i] != -1 and i+j <= amount:
                    if dp[i+j] != -1:
                        dp[i+j] = min(dp[i] + 1, dp[i+j])
                    else:
                        dp[i+j] = dp[i] + 1
        return dp[amount]