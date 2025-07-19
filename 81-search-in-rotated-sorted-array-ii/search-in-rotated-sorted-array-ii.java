class Solution {
    public boolean search(int[] nums, int target) {
        int len=nums.length;
       int end=nums[len-1];
       int start=nums[0];
       int mid=nums[len/2];
       if(target==mid) return true;
       if(target>=start || target<=mid){
        for(int i=0;i<=len/2;i++){
            if(nums[i]==target){
                return true;
            }}}
        if(target>=mid || target<=end){
            for(int i=(len/2)+1;i<len;i++){
                if(nums[i]==target){
                    return true;
                }
            }
        }  

        return false;    
    }
}