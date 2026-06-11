class Solution {

    public int maxCostFinder(int curr,int[] cost,int[] downCost,int runSum,int[] max){
        if(curr>cost.length){
            return 0;
        }

        int index=curr-1;

        int left=maxCostFinder(curr*2,cost,downCost,runSum+cost[index],max);
        int right=maxCostFinder((curr*2)+1,cost,downCost,runSum+cost[index],max);

        downCost[index]=Math.max(left,right)+cost[index];



        max[0]=Math.max(max[0],runSum+cost[index]);
        return downCost[index];
    }



    public int minCostNeeded(int curr,int runSum,int target,int[] cost,int[] downCost){
        if(curr>cost.length){
            return 0;
        }

        int index=curr-1;
        int leftIndex=(curr*2)-1;
        int rightIndex=(curr*2);

        int leftRequired=0,rightRequired=0;


        if(rightIndex<cost.length){
            rightRequired=downCost[rightIndex];
            leftRequired=downCost[leftIndex];
        }

        int max=Math.max(leftRequired,rightRequired);

        int needed=target-(runSum+cost[index]+max);

        
 


        int newRunSum=runSum+cost[index]+needed;


        int left=minCostNeeded(curr*2,newRunSum,target,cost,downCost);
        int right=minCostNeeded((curr*2)+1,newRunSum,target,cost,downCost);

        // System.out.println("curr is : "+curr);
        // System.out.println("left is : "+left);
        // System.out.println("right is : "+right);
        // System.out.println("needed is : "+needed);
        // System.out.println("runSum is : "+runSum+"\n\n");




        return left+right+needed;
    }





    public int minIncrements(int n, int[] cost) {
        int size=n;
        int max[]=new int[1];
        int[] downCost=new int[size];  


        maxCostFinder(1,cost,downCost,0,max); 

        System.out.println(Arrays.toString(downCost));



        int res=0;
         res=minCostNeeded(1,0,max[0],cost,downCost);


        return res;
    }
}