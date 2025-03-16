class Solution(object):
    def lengthOfLastWord(self, s):
        b=s.decode("utf-8")
        c=b.split()
        return len(c[-1]) if c else 0