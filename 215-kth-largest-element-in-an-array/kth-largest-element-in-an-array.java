class Solution {
    public int findKthLargest(int[] nums, int k) {
        ArrayList<Integer> lst=new ArrayList<>();
        Arrays.sort(nums);
        int loc=nums.length-k;
        return nums[loc];
    }
}