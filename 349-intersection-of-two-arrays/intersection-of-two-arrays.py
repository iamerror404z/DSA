class Solution(object):
    def intersection(self, nums1, nums2):
        lst1=set(nums1)
        lst2=set(nums2)
        ans=[]
        for i in lst1:
            if(i in lst2):
                ans.append(i)
        return ans

        