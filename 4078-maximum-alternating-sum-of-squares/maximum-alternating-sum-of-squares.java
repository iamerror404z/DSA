class Solution {
    public long maxAlternatingSum(int[] nums) {
        int len=nums.length;
        if(len==1){
            return nums[0]*nums[0];
        }
        
        int[] array=new int[len];

        

        for(int i=0;i<len;i++){
            array[i]=Math.abs(nums[i]);
        }

        Arrays.sort(array);

        int mid=len/2;

        long pos=0;
        long neg=0;

        for(int i=0;i<mid;i++){
            long square=array[i];
            neg+=(square*square);
            
        }

        for(int i=mid;i<len;i++){
            long square=array[i];
            pos+=(square*square);
        }


        
        
        return pos-neg;
        
    }
}