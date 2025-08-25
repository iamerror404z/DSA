class Solution(object):
    def romanToInt(self, s):
        values = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}
        total = 0
        prev = 0

        # Iterate through the string in reverse
        for char in reversed(s):
            current = values[char]
            # Subtract if the current value is less than the previous value
            if current < prev:
                total -= current
            else:
                total += current
            prev = current

        return total  


        
        