class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        nums.sort()
        point=0
        while(point<len(nums)):
            if(point!=nums[point]):
                return point
            point+=1
        
        return point
        