class Solution(object):
    def threeSum(self, nums):
        nums.sort()  # Sort the list
        result = []

        for i in range(len(nums)):
            # Skip duplicate elements for the first number
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            # Use two-pointer technique to find pairs
            target = -nums[i]
            left, right = i + 1, len(nums) - 1

            while left < right:
                current_sum = nums[left] + nums[right]
                if current_sum == target:
                    result.append([nums[i], nums[left], nums[right]])
                    left += 1
                    right -= 1
                    # Skip duplicates for the second and third numbers
                    while left < right and nums[left] == nums[left - 1]:
                        left += 1
                    while left < right and nums[right] == nums[right + 1]:
                        right -= 1
                elif current_sum < target:
                    left += 1
                else:
                    right -= 1

        return result
