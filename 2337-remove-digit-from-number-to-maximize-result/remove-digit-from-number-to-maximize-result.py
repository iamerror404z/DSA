class Solution:
    def removeDigit(self, number: str, digit: str) -> str:
        candidates = []
        for i in range(len(number)):
            if number[i] == digit:
                candidate = number[:i] + number[i+1:]
                candidates.append(candidate)
        return max(candidates)
