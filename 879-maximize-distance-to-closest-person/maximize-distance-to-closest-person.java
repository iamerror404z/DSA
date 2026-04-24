class Solution {
    public int maxDistToClosest(int[] seats) {
        int size=seats.length;
        int[] left=new int[size];
        int[] right=new int[size];
        int max=0;

        int prev=Integer.MAX_VALUE/2;
        
        for(int i=size-1;i>=0;i--){
            if(seats[i]==1){
                prev=i;
            }
            right[i]=prev-i;
        }

        prev=-Integer.MAX_VALUE/2;
         
         for(int i=0;i<size;i++){
            if(seats[i]==1){
                prev=i;
            }
            left[i]=i-prev;
         }

         for(int i=0;i<size;i++){
            max=Math.max(Math.min(left[i],right[i]),max);
         }


        return max; 
    }
}