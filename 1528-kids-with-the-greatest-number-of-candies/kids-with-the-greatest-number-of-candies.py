class Solution:
    def kidsWithCandies(self, candies: List[int], extraCandies: int) -> List[bool]:
        size=len(candies)
        max1=size*[0]
        max2=size*[0]

        for i in range(1,size):
            max1[i]=max(max1[i-1],candies[i-1])
        
        for i in range(size-2,-1,-1):
            max2[i]=max(max2[i+1],candies[i+1])
        
        ans=[True]*size

        for i in range(0,size):
            if((candies[i]+extraCandies)<max(max1[i],max2[i])):
                ans[i]=False
        
        return ans