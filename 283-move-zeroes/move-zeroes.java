class Solution {
    public void moveZeroes(int[] nums) {
        int count=0;
        int point=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[point++]=nums[i];}}
        for (int j=nums.length-1;j>=point;j--){
            nums[j]=0;
        }
        
    }
}