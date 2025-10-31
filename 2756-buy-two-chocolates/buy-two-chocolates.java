class Solution {
    public int buyChoco(int[] prices, int money) {
        int min1=prices[0];
        int pos1=0;

        for(int i=0;i<prices.length;i++){
            if(prices[i]<min1){
                min1=prices[i];
                pos1=i;
            }
        }

        int min2=0;
        if(pos1!=1){
        min2=prices[1];}
        else{
            min2=prices[0];
        }
        for(int i=0;i<prices.length;i++){
            if(prices[i]<min2 && pos1!=i){
                min2=prices[i];
            }
        }

         System.out.println("min1 : "+min1+"\nmin2 : "+min2);
        int sum=min1+min2;
        
        return (sum<=money)?money-sum:money;
    }
}