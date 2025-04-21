class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        for (int i=0;i<n;i++){
            boolean found=false;
            int test=nums[i];
            for (int j=i+1;j<n;j++){
                if(nums[j]>test){ans[i]=nums[j];found=true;break;}}
            if (!found){
                for (int k=0;k<i;k++){
                    if(nums[k]>test){ans[i]=nums[k];found=true;break;}}}
            if(!found){ans[i]=-1;}}
        return ans;
    }
}