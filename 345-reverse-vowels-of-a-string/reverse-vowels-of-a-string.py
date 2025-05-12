class Solution:
    def reverseVowels(self, s: str) -> str:
        vowels = set('aeiouAEIOU')  # Using a set for faster lookup
        s_list = list(s)           # Convert the string to a list for mutability
        left, right = 0, len(s) - 1
        
        while left < right:
            if s_list[left] not in vowels:
                left += 1
            elif s_list[right] not in vowels:
                right -= 1
            else:
                # Swap the vowels
                s_list[left], s_list[right] = s_list[right], s_list[left]
                left += 1
                right -= 1
        
        return ''.join(s_list)  # Convert the list back to a string
