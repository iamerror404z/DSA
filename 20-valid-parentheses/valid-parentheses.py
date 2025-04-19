class Solution:
    def isValid(self, s: str) -> bool:
        dict ={"{":"}","(":")","[":"]"}
        left=dict.keys()
        lst=[i for i in s]
        change=1;
        while(change!=0):
            change=0
            for i in range(0,len(lst)-1):
                t=lst[i]
                if (t in left) and (lst[i+1]==dict[t]):
                    del lst[i+1]
                    del lst[i]
                    change+=1
                    break
        print (len(lst)==0)
        return (len(lst)==0)