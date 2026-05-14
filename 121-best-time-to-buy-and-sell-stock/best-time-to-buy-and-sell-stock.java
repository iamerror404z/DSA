class Solution {
    public int maxProfit(int[] prices) {
        int max=0;
        int size=prices.length;
        int[] min=new int[size];
        min[0]=prices[0];

        for(int i=1;i<size;i++){
            min[i]=Math.min(prices[i],min[i-1]);
        }

        int currMax=prices[size-1];
        

        for(int i=size-1;i>=0;i--){
            currMax=Math.max(currMax,prices[i]);
            int tempMax=currMax-min[i];
            max=Math.max(max,tempMax);

        }


        System.out.println(Arrays.toString(min));





        return max;
    }
}