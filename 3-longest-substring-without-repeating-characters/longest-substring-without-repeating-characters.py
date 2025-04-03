class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        sep=max=(len(list(set(s))))
        ans=0
        pf=False
        if max<=1:
            return max
        elif max==len(s):
            return max
        while (pf!=True):
            for i in range(0,len(s)-sep+1):
                test=s[i:i+sep]
                if len(set(test))==max:
                    ans =max
                    pf=True

            sep-=1
            max-=1

        return  (ans)
        