class Solution {
    public int minOperations(int[] nums) {
    int start=nums[0];
    
    for(int i:nums){
        if(i!=start){
            start=i;
            break;
        }
    }
    
    if(start==nums[0]){
        return 0;
    }


        return 1;
    }
}