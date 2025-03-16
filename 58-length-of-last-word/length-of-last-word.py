class Solution(object):
    def lengthOfLastWord(self, s):
       decoded_str = s.decode("utf-8")
        # Split the decoded string into words
       words = decoded_str.split()
        # Return the length of the last word, or 0 if no words exist
       return len(words[-1]) if words else 0