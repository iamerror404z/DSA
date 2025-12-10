class Solution {

    public boolean isPossible(int[] piles,int h,int k){
        long count=0;
        for(int i:piles){
            count+=(i/k);
            if(i%k!=0){
                count++;
            }
        }
        return count<=(long)h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MAX_VALUE;
        for(int i:piles){
            if(i>max)max=i;
        }

        int start=1;
        int end=max;
        int ans=Integer.MAX_VALUE;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(isPossible(piles,h,mid)){
                ans=Math.min(ans,mid);
                end=mid-1;
            }else{
                start=mid+1;
            }
        }



        return ans;   
    }
}