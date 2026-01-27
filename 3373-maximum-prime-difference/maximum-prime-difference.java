class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int max=0;

        
        for(int i:nums){
            if(i>max){
                max=i;
            }
    }
        int[] isPrime=new int[max+1];
        
        if(max>=2){
            isPrime[2]=1;
        }

        for(int i=3;i<=max;i+=2){
            isPrime[i]=1;
        }


        for(int i=3;i<=Math.sqrt(max);i+=2){
            if(isPrime[i]==1){
                for(int j=i*i;j<=max;j+=i){
                    isPrime[j]=0;
                }
            }
        }

        int length=nums.length;

        int forward=length;
        int backward=0;
        int primeCount=0;

        for(int i=0;i<length;i++){
            if(isPrime[nums[i]]==1){
                forward=Math.min(forward,i);
                backward=Math.max(backward,i);
                primeCount++;
            }
        }


        return (primeCount>=2)?backward-forward:0;
    }
}