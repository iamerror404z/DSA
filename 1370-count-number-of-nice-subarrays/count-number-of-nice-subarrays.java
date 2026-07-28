class Solution {


    public int countSubArr(Deque<Integer> deque,int end,int prevStart){
        int cycleStart=deque.pollFirst();
        int cycleEnd=deque.isEmpty()?cycleStart:deque.peekLast();

        // finding out the nums of sub arrs in given range
        int cycleLength=end-cycleEnd;
        int prevLength=cycleStart-prevStart;




        return cycleLength*prevLength;
    }


    public int numberOfSubarrays(int[] nums, int k) {
        int count=0;
        int length=nums.length;
        Deque<Integer> queue=new LinkedList<>();

        
        int oddSize=0;
        int start=-1;

        for(int i=0;i<length;i++){
            int curr=nums[i];
            int odd=curr%2;

            if(odd==1 && queue.size()<k){
                queue.addLast(i);
            }else if(odd==1 && queue.size()==k){
                int nextStart=queue.peekFirst();
                
                int cycleCount=countSubArr(queue,i,start);
                count+=cycleCount;
                System.out.println(cycleCount);

                start=nextStart;
                queue.addLast(i);
            }
            
            
        }

        int finalCount=0;

        if(queue.size()==k){
        finalCount=countSubArr(queue,length,start);}



        return finalCount+count;
        
    }
}