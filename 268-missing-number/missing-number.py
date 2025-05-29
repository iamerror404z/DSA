class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        max=-1
        sum=0
        low=-1
        for i in nums:
            if(i>max):
                max=i
            if (i==0):
                low=0
            sum+=i
        math=max*(max+1)//2-sum
        print(math)
        if(math==0 and low==0):
            return max+1

        return math
        