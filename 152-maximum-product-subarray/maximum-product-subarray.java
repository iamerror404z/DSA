class Solution {
    public int maxProduct(int[] nums) {
        int length=nums.length;
        long[] track=new long[length];
        long product=1;
        int start=0;

        for(int i=0;i<length;i++){
            product*=nums[i];
            track[i]=product;
            if(nums[i]==0){
                start=i+1;
                product=1;
            }
        }


        int[] negative=new int[length+1];
        negative[length]=1;
        int prev=length;

        for(int i=length-1;i>=0;i--){
            if(nums[i]<0){
                prev=i;
            }
            negative[i]=prev;
        }


        int max=(int)track[0];
        start=0;

        for(int i=0;i<length;i++){
            if(track[i]==0){
                start=i+1;
                max=Math.max(0,max);
            }else if(track[i]>0){
                max=Math.max(max,(int)track[i]);
            }else{
                int index=negative[start];
                long tempMax=track[i];

                if(index<i){
                    tempMax/=track[index];
                    max=Math.max(max,(int)tempMax);
                }

            }
        }


        

        return max;
    }
}