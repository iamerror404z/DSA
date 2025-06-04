class Solution {
    public int pivotIndex(int[] nums) {
        int len=nums.length;
        int sum=0;

        for(int i:nums){
            sum+=i;
        }

        if(sum-nums[0]==0){
            return 0;
        }

        

        int leftSUM=0;
        for(int i=0;i<len;i++){
            int current=nums[i];
            if(leftSUM==sum-leftSUM-current){
                return i;
            }
            leftSUM+=current;
        }

        if(sum-nums[len-1]==0){
            return len-1;
        }
        
        return -1;
    }
}