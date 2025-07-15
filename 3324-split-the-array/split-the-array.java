class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        Set<Integer> nums1=new HashSet<Integer>();
        Set<Integer> nums2=new HashSet<Integer>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i+=2){
            nums1.add(nums[i]);
            nums2.add(nums[i+1]);
        }
        if(nums1.size()==nums2.size() && nums1.size()==nums.length/2)
        return true;
        else
        return false;
    }
}