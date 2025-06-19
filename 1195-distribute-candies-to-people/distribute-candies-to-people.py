class Solution:
    def distributeCandies(self, candies: int, num_people: int) -> List[int]:
        lst=num_people*[0]
        count=1
        num=0
        pos=0

        while(candies!=0):
            num=min(count,candies)
            lst[pos]+=num
            candies-=num
            count+=1
            pos+=1

            if(pos==num_people):
                pos=0
        return lst

        