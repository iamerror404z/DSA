class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        lst=list()
        poss=list()
        neg=list()
        ps=0
        ns=0
        for i in nums:
            if(i<0):
                neg.append(i)
                ns+=1
            else:
                poss.append(i)
                ps+=1
        
        point1=0
        point2=0
        while(point1<ns or point2<ps):
            if(point2<ps):
                lst.append(poss[point2])
                point2+=1
            if(point1<ns):
                lst.append(neg[point1])
                point1+=1
        return lst
