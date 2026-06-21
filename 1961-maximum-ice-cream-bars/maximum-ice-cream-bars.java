class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max=0;

        for(int i:costs){
            max=Math.max(max,i);
        }

        int[] freq=new int[max+1];

        for(int i:costs){
            freq[i]++;
        }
        int totalCount=0;
        int totalCost=0;
        int size=costs.length;

        int pointer=1;


        while(pointer<=max && totalCost<coins){
            int availCost=coins-totalCost;
            int maxBuy=availCost/pointer;

            if(maxBuy==0){
                return totalCount;
            }

            int buyCount=Math.min(maxBuy,freq[pointer]);

            totalCount+=buyCount;
            totalCost+=(pointer*buyCount);


            pointer++;
        }



        



        return totalCount;
    }
}