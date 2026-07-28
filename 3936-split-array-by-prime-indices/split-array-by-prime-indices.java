class Solution {

    public int[] buildPrimeMap(int length){
        int[] isPrime=new int[length+1];

        if(length>=2){
            isPrime[2]=1;
        }

        for(int i=3;i<=length;i+=2){
            isPrime[i]=1;
        }

       System.out.println("isPrime arr before process is : "+Arrays.toString(isPrime));

        for(int i=3;i*i<=length;i+=2){
            
            if(isPrime[i]==1){
                for(int j=3;j*i<=length;j+=2){
                    isPrime[j*i]=0;
                }

            }

        }




        return isPrime;


    }



    public long splitArray(int[] nums) {
        int length=nums.length;

        int[] isPrime=buildPrimeMap(length-1);

        System.out.println(Arrays.toString(isPrime));

        long sum1=0;
        long sum2=0;


        for(int i=0;i<length;i++){
            int curr=nums[i];
            if(isPrime[i]==1){
                sum1+=curr;
            }else{
                sum2+=curr;
            }
        }




        return Math.abs(sum1-sum2);
    }
}