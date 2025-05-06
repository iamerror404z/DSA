class Solution:
    def addBinary(self, a: str, b: str) -> str:
        n1=int(a,2)
        n2=int(b,2)
        ans=n1+n2
        step=bin(ans)[2:]
        return step
        