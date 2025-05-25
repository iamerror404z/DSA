class Solution {
    public int[] singleNumber(int[] nums) {
       int[] ans =new int[2]; 
       int position=0;
       int size=nums.length;
       int n=size;
       if(size==2){
        return nums;
       }
       Arrays.sort(nums);

        if(nums[0]!=nums[1]){
            ans[position++]=nums[0];
        }
        int left=1;
        int right;
        int current=nums[1];
        while(left<n-1){
            right=left;
            current=nums[right];
            while(right<n-1 &&current==nums[right+1]){
                right++;
            }
            if(nums[right]!=nums[right-1] && nums[right]!=nums[right+1]){
                ans[position++]=nums[right];
            }
            left=right+1;
        }
        if(nums[n-1]!=nums[n-2]){
            ans[position++]=nums[n-1];
        }

            return ans;
    }
}