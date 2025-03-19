class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        if target in nums:
            return nums.index(target)
        else:
            for i in nums:
                if target<min(nums):
                    return 0
                
                if i>target:
                    return (nums.index(i))
                elif max(nums)<target:
                    return len(nums)
                
        