class Solution {
    public int[] numberGame(int[] nums) {
        int size=nums.length;
        int[] ans=new int[size];
        Arrays.sort(nums);

        for(int i=0;i<size;i+=2){
            ans[i]=nums[i+1];
            ans[i+1]=nums[i];
        }



        return ans;
    }
}