class Solution {
    public int minimumDeletions(int[] nums) {
        int minPos=0;
        int maxPos=0;

        int length=nums.length;
        for(int i=0;i<length;i++){
            int curr=nums[i];

            if(curr<nums[minPos]){
                minPos=i;
            }

            if(curr>nums[maxPos]){
                maxPos=i;
            }
        }

        int left=Math.min(minPos,maxPos);
        int right=Math.max(maxPos,minPos);


        int minDeletions=length;

        int leftDistance=0;
        int rightDistance=0;
        
        // poss1 delete it from both the end
        leftDistance=left+1;
        rightDistance=length-right;
        int poss1=leftDistance+rightDistance;

        // poss2 delete the left and remove the element from left to the right 
        int poss2=(right+1);
      

        // poss3 delete elements from the right most to left most;
        int poss3=length-(left);
        int min=Math.min(poss1,poss2);
        min=Math.min(min,poss3);


        return min;
    }
}