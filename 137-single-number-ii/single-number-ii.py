class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        count=0
        lst=set(nums)
        for  i in lst:
            if (nums.count(i)==1):
                return i
        return 1
        