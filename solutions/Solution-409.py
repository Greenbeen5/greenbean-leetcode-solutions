class Solution:
    def longestPalindrome(self, s: str) -> int:
        d = collections.Counter(s)
        max_parl = 0
        odd = 0
        for k in d:
            if d[k]%2 == 0:
                max_parl += d[k]
            else:
                max_parl += (d[k] - 1)
                odd = 1
        max_parl += odd
        return max_parl