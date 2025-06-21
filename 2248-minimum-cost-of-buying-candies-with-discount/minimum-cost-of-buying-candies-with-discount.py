class Solution:
    def minimumCost(self, cost: List[int]) -> int:
        cost.sort()
        size=len(cost)
        req=0
        count=1
        for i in range(size-1,-1,-1):
            if(count!=3):
                req+=cost[i]
                count+=1
            elif(count==3):
                count=1
        
        return req