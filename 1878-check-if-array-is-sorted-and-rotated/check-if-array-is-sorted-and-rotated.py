class Solution:
    def check(self, nums: List[int]) -> bool:
        point=-1
        for i in range(1,len(nums)):
            if(nums[i-1]>nums[i]):
                point=i-1
                break
        for j in range(point+2,len(nums)):
            if(nums[j-1]>nums[j]):
                return False
        if(point!=-1):
            if(nums[len(nums)-1]>nums[0]):
                return False
        return True
        