class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        lst=set(nums)
        longest=0
        for i in lst:
            if i-1 not in lst:
                current_num=i
                streak=1
                while(current_num+1 in lst):
                    current_num+=1
                    streak+=1
                longest= max(streak,longest)
        return longest