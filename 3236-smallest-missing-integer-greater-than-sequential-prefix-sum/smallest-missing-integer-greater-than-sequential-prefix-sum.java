class Solution {
    public int missingInteger(int[] nums) {
        int prev=nums[0];
        int prefixSum=nums[0];
        int length=nums.length;
        
        if(length==1){
            return nums[0]+1;
        }
       



        for(int i=1;i<length;i++){
            int curr=nums[i];
            
            if(curr!=prev+1){
                break;
            }


            prefixSum+=curr;
            prev=curr;
        }   

        // build map;
        boolean[] map=new boolean[52];
        for(int i:nums){
            map[i]=true;
        }




        for(int i=prefixSum;i<=51;i++){
            if(!map[i]){
                return i;
            }

        }


        return prefixSum;
    }
}