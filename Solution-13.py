class Solution:
    def romanToInt(self, s: str) -> int:
        specials = {"IV":4, "IX":9, "XL":40, "XC":90, "CD":400, "CM":900}
        normal = {"I":1, "V":5, "X":10, "L":50, "C":100, "D":500, "M":1000}
        lst = list(s)
        rg = len(lst)
        total = 0
        i = 0
        while i < rg:
            if i + 1 < rg:
                try:
                    total += specials[ lst[i] + lst[i+1] ]
                    i += 2
                    continue
                except:
                    pass
            total += normal[lst[i]]
            i += 1
        return total     