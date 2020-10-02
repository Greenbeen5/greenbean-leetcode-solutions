class Solution:
    def numJewelsInStones(self, J: str, S: str) -> int:
        Jset = set(J)
        jewels = 0
        for i in range(len(S)):
            if S[i] in Jset:
                jewels += 1
        return jewels