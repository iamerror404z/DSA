class Solution(object):
    def sortEvenOdd(self, nums):
        ans=nums
        size=len(nums)
        even,odd=[],[]
        for i in range(0,size):
            if (i%2==0):
                even.append(nums[i])
            else:
                odd.append(nums[i])
        odd.sort(reverse=True)
        even.sort()
        max1=len(odd)
        max2=len(even)
        point=0
        pos1,pos2=0,0
        for j in range(0,size):
            if ((j%2==0) and (pos2<max2)):
                ans[point]=even[pos2]
                point+=1
                pos2+=1
            elif (pos1<max1):
                ans[point]=odd[pos1]
                point+=1
                pos1+=1
        while(pos2<max2):
            ans[point]=even[pos2]
            point+=1
            pos2+=1
            
        while(pos1<max1):
            ans[point]=odd[pos1]
            point+=1
            pos1+=1
            
        return (ans)