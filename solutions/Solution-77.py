class Solution:
    def combine(self, n: int, k: int) -> List[List[int]]:
        lst = [i for i in range(1, n + 1)] # just to try list comprehension
        combs = itertools.combinations(lst, k)
        res = []
        for c in combs:
            res.append(list(c))
        return res