class Solution:
    def findContinuousSequence(self, target: int) -> List[List[int]]:
        out = []
        half = target / 2 + 1
        i = 1
        j = 2
        cur_sum = 3
        if target == 1:
            return [[1]]
        elif target == 2:
            return [[2]]
        else:
            while j <= half:
                if cur_sum == target:
                    out.append(list(range(i,j+1)))
                    j += 1
                    cur_sum += j
                elif cur_sum < target:
                    j += 1
                    cur_sum += j
                else:
                    cur_sum -= i
                    i += 1
        return out