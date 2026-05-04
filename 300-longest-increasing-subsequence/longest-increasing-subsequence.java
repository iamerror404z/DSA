class Solution {
    public int lengthOfLIS(int[] nums) {
        int max=1;
        int size=nums.length;
        int[] lis=new int[size];
        lis[size-1]=1;

        
        

        for(int i=size-2;i>=0;i--){
            int tempLis=0;
            for(int j=size-1;j>i;j--){
                if(nums[i]<nums[j]){
                    tempLis=Math.max(tempLis,lis[j]);
                }}

               
                lis[i]+=tempLis;
                lis[i]++;
                max=Math.max(max,lis[i]);
            

        }


        


        return max;
    }
}