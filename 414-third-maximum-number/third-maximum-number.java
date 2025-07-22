class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int len=nums.length;
        int pointer=len-1;
        int step=1;
        while(pointer>0 &&step!=3){
            if(nums[pointer]!=nums[pointer-1]){
                step++;
            }
            pointer--;
        }
        if(step<3){
            return nums[len-1];
        }

        return nums[pointer];
    }
}