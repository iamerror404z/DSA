class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans=new int[2];

        Arrays.sort(nums);
        int left=0;
        int right=0;
        int len=nums.length;
        int pointer=0;

        while(left<len){
            int temp=nums[left];
            right=left;
            while(right+1<len && nums[right+1]==temp){
                right++;
            }

            if(left!=right){
                ans[pointer++]=temp;
                left=right;
            }
            if(pointer>=2){
                return ans;
            }

            left++;
        }



        return ans;
        
    }
}