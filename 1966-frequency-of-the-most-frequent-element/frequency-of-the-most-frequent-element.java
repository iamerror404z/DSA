class Solution {
    public int maxFrequency(int[] nums, int k) {
        int max=0;
        Arrays.sort(nums);
        

        int start=0;
        int size=nums.length;
        long windowSum=0;
        long kCount=0;


        for(int i=0;i<size;i++){
            while(windowSum+k<(long)nums[i]*(long)(i-start)){
                windowSum-=nums[start];
                start++;
            }

            // System.out.println("Start is : "+start+"end is : "+i+"nums is : "+nums[i]);
            max=Math.max(max,i-start+1);
            windowSum+=nums[i];
        }




        return max;

    }
}