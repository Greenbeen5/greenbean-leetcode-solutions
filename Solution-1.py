class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mapper = {}
        for i in range(len(nums)):
            if target - nums[i] == nums[i]:
                 for j in range(i+1,len(nums)):
                        if nums[j] == nums[i]:
                            return [i,j]
            mapper[str(target - nums[i])] = i
        for j in range(len(nums)):
            if mapper.get(str(nums[j])) != None and mapper.get(str(nums[j])) != j:
                ans = [mapper.get(str(nums[j])),j]
                ans.sort()
                return ans