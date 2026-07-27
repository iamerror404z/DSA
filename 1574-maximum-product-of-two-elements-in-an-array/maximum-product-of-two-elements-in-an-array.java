class Solution {
    public int maxProduct(int[] nums) {
        int[] max=new int[2];

        int length=nums.length;

        for(int i=0;i<length;i++){
            int curr=nums[i];

            if(curr>max[0]){
                max[1]=max[0];
                max[0]=curr;
            }else if(curr>max[1]){
                max[1]=curr;
            }

        }



        return (max[0]-1)*(max[1]-1);
    }
}