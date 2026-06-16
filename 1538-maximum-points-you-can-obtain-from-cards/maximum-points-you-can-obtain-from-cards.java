// optimizing from o(n) sc ==> o(1)

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max=0;
        int size=cardPoints.length;
        int end=size-1;

        long leftSum=0;
        long rightSum=0;

        for (int i=0;i<k;i++){
            leftSum+=cardPoints[i];
            rightSum+=cardPoints[end-i];

        }

        // System.out.println(preSum+"  "+postSum);

       int[] left=new int[2];
       int[] right=new int[2];

       left[1]=k-1;
       right[0]=end;
       right[1]=end-k+1;

        for(int i=0;i<k;i++){
            if(leftSum>=rightSum){
                max+=cardPoints[left[0]];
                leftSum-=cardPoints[left[0]];
                left[0]++;

                rightSum-=cardPoints[right[1]];
                right[1]++;
            }else{
                max+=cardPoints[right[0]];
                rightSum-=cardPoints[right[0]];
                right[0]--;

                leftSum-=cardPoints[left[1]];
                left[1]--;
            }
        }


        return max;
        
    }
}