class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer,long[]> map=new HashMap<>();
        long max=0;
        long windowSum=0;

        map.put(nums[0],new long[]{0,nums[0]});

        long sum=nums[0]; 
        int start=0;
        int size=nums.length;

        if(k==1){
            max=nums[0];
        }

        for(int i=1;i<size;i++){
            int curr=nums[i];
            sum+=curr;

            boolean hasPop=false,hasDup=false;

            if(start<i+1-k){
                hasPop=true;
                start++;
            }

            long []info=map.getOrDefault(curr,new long[]{-1,0});

            if(info[0]>=start){
                hasDup=true;
                start=(int)info[0]+1;
            }

            
            if(hasDup){
                windowSum=sum-info[1];
            }else if(hasPop){
                long preSum=map.get(nums[start-1])[1];
                windowSum=sum-preSum;
            }else{
                long preSum=map.get(nums[start])[1];
                windowSum=sum-preSum+nums[start];
            }




            if(i+1-start==k){
                max=Math.max(max,windowSum);
            }
            
            info[0]=i;
            info[1]=sum;
            map.put(curr,info);


        }







        return max;

    }
}