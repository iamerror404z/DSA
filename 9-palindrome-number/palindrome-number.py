class Solution(object):
    def isPalindrome(self, x):
        y=str(x)
        z=""
        for i in range(-1,-len(y)-1,-1):
            z+=y[i]
        return (str(x)==(z))

        