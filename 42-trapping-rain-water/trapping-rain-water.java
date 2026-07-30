class Solution {


    public int amountOfWater(Stack<Integer> stack,int[] heights,int boundry1Index){
        int blocked=0;
        int boundry1=heights[boundry1Index];


        int boundry2Index=0;

        while(!stack.isEmpty() && boundry1>heights[stack.peek()]){
            int currIndex=stack.pop();
            int currVal=heights[currIndex];

            int nextIndex=stack.isEmpty()?currIndex:stack.peek();
            
            int currDistance=nextIndex-currIndex;
            int currBlocked=currDistance*currVal;
            blocked+=currBlocked;



            boundry2Index=currIndex;
        }

        if(!stack.isEmpty()){
            // update boundry2
            boundry2Index=stack.peek();
        }

        int water=0;
        int boundry2=heights[boundry2Index];

        int distance=boundry2Index-boundry1Index-1;

        int cap=distance*Math.min(boundry1,boundry2);

        water=Math.max(0,cap-blocked);

        System.out.println("cap is : "+cap);
        System.out.println("blocked is : "+blocked);




        return water;
    }


    public int trap(int[] height) {
       int totalWater=0;
       
       int length=height.length;
       Stack<Integer> stack=new Stack();
       
       stack.push(length-1);


       for(int i=length-2;i>=0;i--){
            int prev=height[stack.peek()];
            int curr=height[i];
            int intervalwater=0;

            if(curr>prev){
                intervalwater=amountOfWater(stack,height,i);
                System.out.println("water is : "+intervalwater);

            }

            
            // System.out.println("indeex is : "+i);
            // System.out.println("nums is : "+curr);
            // System.out.println("water is : "+water+"\n");

            stack.add(i);
            totalWater+=intervalwater;
       }
        
        





        return totalWater;
    }
}