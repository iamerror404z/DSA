class Solution {
    public int findMaxK(int[] nums) {
     Arrays.sort(nums);
     int left=0;
     int len=nums.length;
     int right=len-1;
     int num=nums[left];
     while(left<len && right>=0 &&nums[left]<0 && nums[right]>0){
        if(-1*nums[left]==nums[right]){
            return nums[right];
        }else if(-1*nums[left]>nums[right]){
            left++;
        }else{
            right--;
        }
     }

    return -1;
    }
}