class Solution:
    def differenceOfSum(self, nums: List[int]) -> int:
        sum=0
        digit=0

        for i in nums:
            k=i
            while(k!=0):
                digit+=(k%10)
                k//=10
            sum+=i

        return abs(sum-digit)