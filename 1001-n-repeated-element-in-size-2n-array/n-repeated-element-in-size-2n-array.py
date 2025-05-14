class Solution:
    def repeatedNTimes(self, nums: List[int]) -> int:
        point=len(nums)//2

        st=set(nums)
        for i in st:
            if nums.count(i)==point:
                return i

        return 0
