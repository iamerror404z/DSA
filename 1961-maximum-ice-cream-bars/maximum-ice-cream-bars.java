class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int totalCost=0;
        int count=0;
        int size=costs.length;

        for(int cost:costs){
            if(totalCost+cost<=coins){
                totalCost+=cost;
                count++;
            }else{
                return count;
            }
        }



        return count;
    }
}