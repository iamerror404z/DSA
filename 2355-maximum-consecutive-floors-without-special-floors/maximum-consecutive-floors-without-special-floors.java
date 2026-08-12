class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);

        int prev=special[0];
        int length=special.length;
        int max=0;

        for(int i=1;i<length;i++){
            int curr=special[i];

            int floorCount=curr-prev-1;


            max=Math.max(max,floorCount);
            prev=curr;
        }

        int startMax=special[0]-bottom;
        int endMax=top-special[length-1];

        max=Math.max(max,Math.max(startMax,endMax));



        return max;
    }
}