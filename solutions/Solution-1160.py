class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        d1 = {}
        d2 = {}
        chs = "abcdefghijklmnopqrstuvwxyz"
        ans = 0
        for i in range(len(chs)):
            d1[chs[i]]=0
            d2[chs[i]]=0
        for c in chars:
            d1[c] += 1
        for w in words:
            flag = False
            for ch in w:
                d2[ch] += 1
            for key in d2:
                if(d1[key] < d2[key]):
                    flag = True
                d2[key] = 0
            if flag == False:
                ans += len(w)
        return ans