class Solution {
    public int removeDuplicates(int[] nums) {

        int pointer=0;
        int left=0;
        int right=0;
        int length=nums.length;


        while(pointer<length && right<length && left<length){
            int curr=nums[left];
            right=left;

            while(right<length && nums[right]==curr && right-left+1<=2){
                nums[pointer++]=nums[right++];
            }

            while(right<length && nums[right]==curr){
                right++;
            }


            left=right;
        }


        

        return pointer;
    }
}