class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        nums =nums1 +nums2
        nums.sort()
        if len(nums)%2==1:
            return nums[(len(nums) - 1) // 2]
        else:
            mid = len(nums)/2
            value=nums[mid]+nums[mid-1]
            value/=2.0
            return value
        