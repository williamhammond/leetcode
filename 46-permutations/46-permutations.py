class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        return self.backtrack([], [], nums)
    
    def backtrack(self, result: List[List[int]], current: List[int], nums: List[int]) -> List[List[int]]:
        if (len(current) == len(nums)):
            result.append(deepcopy(current))
        else:
            for i in range(len(nums)):
                if nums[i] in current:
                    continue
                current.append(nums[i])
                self.backtrack(result, current, nums)
                current.pop()
        return result
        
        