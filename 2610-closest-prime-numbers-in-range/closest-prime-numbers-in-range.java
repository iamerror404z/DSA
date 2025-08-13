class Solution {
    public int[] closestPrimes(int left, int right) {
        int[] isPrime=new int[right+1];
        left=Math.max(2,left);
        
        for(int i=1;i<=right;i++){
            isPrime[i]=1;
        }
        for(int i=2;i<=Math.sqrt(right);i++){
            if(isPrime[i]==1){
                for(int j=i+i;j<=right;j+=i){
                    isPrime[j]=0;
                }
            }
        }

        
        
        int[] temp={-1,-1};
        int lPointer=left;
        int rPointer=0;
        int min=Integer.MAX_VALUE;
        int val1=-1,val2=-1;
        

        for(int i=left;i<right+1;i++){
            if(isPrime[i]==1){
                if(val1==-1){
                    val1=i;
                }else{
                    val2=i;
                }
            }
            if(val1!=-1 && val2!=-1){
                if(val2-val1<min){
                    min=val2-val1;
                    temp[0]=val1;
                    temp[1]=val2;
                }

                val1=val2;
                val2=-1;
            }
        }


        return  temp;
        
    }
}