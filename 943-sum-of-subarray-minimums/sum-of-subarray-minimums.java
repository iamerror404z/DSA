class Solution {


    public void  process(Deque<Integer> deque,int prev,int[] arr,int[] sum){
        int endIndex=deque.peekLast();
        int mod=sum[1];
        


        while(!deque.isEmpty() && prev<arr[deque.peekLast()]){
            int currIndex=deque.pollLast();
            int prevIndex=deque.isEmpty()?-1:deque.peekLast();

            // finding the total number of times per a cycle
            long cycle=1;

            long cycleLength=endIndex-currIndex+1;
            cycle=cycleLength*arr[currIndex];
            // we are done with the sum per a cycle 


            int numOfCycles=currIndex-prevIndex;
            long ans=((numOfCycles)*cycle)%mod;
            ans+=sum[0];

            sum[0]=(int)(ans%mod);

            // long totalContribution=contribution*times;

            // System.out.println("c is : "+contribution);

            // long tempSum=(contribution+sum[0]);
            // sum[0]=(int)(tempSum%sum[1]);


        }

       

        

    }



    public int sumSubarrayMins(int[] arr) {
        final int mod=(int)Math.pow(10,9)+7;
        int[] sum=new int[2];
        sum[1]=mod;

        Deque<Integer> deque=new LinkedList<>(); 
        
        
        deque.addLast(0);
        int size=arr.length;


        for(int i=1;i<size;i++){
            int prev=arr[deque.peekLast()];
            
            int curr=arr[i];

            if(curr<prev){
                process(deque,arr[i],arr,sum);
                deque.add(i);
            }else{
                deque.add(i);
            }


        }



        process(deque,-1,arr,sum);





        return sum[0];
        
    }
}