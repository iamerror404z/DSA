class Solution(object):
    def plusOne(self, digits):
        z=""
        lst=[]
        for i in digits:
            z+=str(i)
        t= int(z) +1
        t=str(t)
        for ele in t:
            lst.append(int(ele))
        return lst


        