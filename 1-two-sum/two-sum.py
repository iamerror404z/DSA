class Solution(object):
    def twoSum(self, nums, target):
     prevmap={}

     for i in range(0,len(nums)):
        diff=target-nums[i]
        if(diff in prevmap):
            return [prevmap[diff],i]
        prevmap[nums[i]]=i
    