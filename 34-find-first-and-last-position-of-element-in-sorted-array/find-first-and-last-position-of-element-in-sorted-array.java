class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        int pt=0;
        boolean found=false;
        for(int i=0;i<nums.length;i++){
            
        if(nums[i]==target){
            if(pt==0){
                pt=1;
                ans[0]=i;
            }else{
                pt=2;
                ans[1]=i;
            }}
        if(nums[i]>target){break;}}
        if(pt==1){ans[1]=ans[0];}
        if(pt==0){
            ans[0]=-1;
            ans[1]=-1;
        }
        return ans;}
        
}