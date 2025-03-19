class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        val=n
        if n==1:
            return True
        elif n<3 and n!=1:
            return False
        else:
            while(val>=3):
                val/=3
                #print(val)
            if val==1.00:
                    return True
            else:
                return False