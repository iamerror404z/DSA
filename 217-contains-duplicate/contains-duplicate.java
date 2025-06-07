class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        int left=0;
        int right;
        while(left<nums.length){
            int current=nums[left];
            right=left;
            while(right<nums.length-1 && nums[right+1]==current){
                right++;
            }
            if(right-left+1>=2)
                return true;
            left=right+1;
            
        }

        return false;
        
    }
}