class Solution {

    public long maximizeNum(int num){
        int[] digits=new int[10];

         int b=num;
        while(b!=0){
            digits[b%10]++;
            b/=10;
        }

        long max=0;

        for(int i=9;i>=1;i--){

            for(int j=0;j<digits[i];j++){
                max=max*10+i;
            }
        }
        
        max*=Math.pow(10,digits[0]);

        return  max-num; 
    }



    public long maximizeSum(int[] nums, int k) {
        int length=nums.length;
        long[] maxNums=new long[length];

        long res=0;
        for(int i=0;i<length;i++){
            maxNums[i]=maximizeNum(nums[i]);
            res+=nums[i];
        }

        Arrays.sort(maxNums);
        for(int i=length-1;i>=length-k;i--){
            res+=maxNums[i];
        }


        return res;
    }
}

