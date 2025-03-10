class Solution(object):
    def removeElement(self, nums, val):
        a=0 
        for i in range(len(nums)):
            if nums[i]!=val:
                nums[a]=nums[i]
                a+=1
        return a





    
        