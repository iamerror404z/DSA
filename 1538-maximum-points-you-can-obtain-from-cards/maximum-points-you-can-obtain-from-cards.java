class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int size=cardPoints.length;
        int[] postSum=new int[size];
        int[] preSum=new int[size];
        int end=size-1;

        preSum[0]=cardPoints[0];
        postSum[end]=cardPoints[end];


        for(int i=1;i<size-1;i++){
            preSum[i]=preSum[i-1]+cardPoints[i];
            postSum[end-i]=postSum[end-i+1]+cardPoints[end-i];

        }

        preSum[end]=preSum[end-1]+cardPoints[end];


        if(end>=1){
        postSum[0]=postSum[1]+cardPoints[0];}

        int max=0;

        System.out.println(Arrays.toString(preSum));
        System.out.println(Arrays.toString(postSum));


        int startPointer=0;
        int endPointer=end;

        for(int i=1;i<=k;i++){
            int rem=k-i;
            int leftSum=cardPoints[startPointer]-preSum[startPointer]+preSum[Math.min(end,startPointer+rem)];
            int rightSum=cardPoints[endPointer]-postSum[endPointer]+postSum[Math.max(0,endPointer-rem)];


            if(leftSum>=rightSum){
                max+=cardPoints[startPointer];
                startPointer++;
            }
            else{
                max+=cardPoints[endPointer];
                endPointer--;
            }
            
        }



        return max;
        
    }
}