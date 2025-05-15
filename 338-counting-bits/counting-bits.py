class Solution:
    def countBits(self, n: int) -> List[int]:
        # Initialize the result array with zeros
        dp = [0] * (n + 1)
        
        # Populate the dp array
        for i in range(1, n + 1):
            dp[i] = dp[i >> 1] + (i & 1)  # Right shift and check the last bit
        
        return dp
