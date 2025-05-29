class Solution {
    public int singleNonDuplicate(int[] nums) {
        Arrays.sort(nums);
        int left=0;
        int right;
        int len=nums.length;

        while(left<len){
            right=left;
            int current=nums[left];
            while(right<len-1 && current==nums[right+1]){
                right++;
            }
            if(left==right){
                return current;
            }
            left=right+1;
        }

        return 963;
    }
}