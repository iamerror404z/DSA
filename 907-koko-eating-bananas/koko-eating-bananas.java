class Solution {

    public boolean isPossible(int[] piles,int h,int k){
        long count=0;
        
        int left=0;
        int right=piles.length-1;;

        while(left<right){
            count+=piles[left]%k!=0?(piles[left]/k)+1:(piles[left]/k);
            count+=piles[right]%k!=0?(piles[right]/k)+1:piles[right]/k;
            left++;
            right--;
        }

        int size=piles.length;

        if(size%2!=0){
            count+=piles[size/2]%k==0?piles[size/2]/k:(piles[size/2]/k)+1;
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