class Solution {
    public int longestSubarray(int[] nums) {
        int len=nums.length;
        int[] forward=new int[len];
        int[] backward=new int[len];
        int left=0,right=0;
        
        while(left<len-1){
            right=left;
            while(right<len-1 &&nums[right]!=0){
                right++;
            }

            if(nums[right]==0){
            forward[right]=right-left;}


            left=right+1;
        }

        left=len-1;
        right=left;

        while(left>0){
            right=left;
            while(right>0 && nums[right]!=0){
                right--;
            }
            if(nums[right]==0){
            backward[right]=left-right;}

            left=right-1;
        }

        System.out.println(Arrays.toString(forward));

        int max=0;

        for(int i=0;i<len;i++){
            if(nums[i]==0){
                max=Math.max(max,(forward[i]+backward[i]));
            }
        }

        if(max==0){
            if(nums[0]==0){
                return 0;
            }else{
                return len-1;
            }
        }
        return max;
    }
}