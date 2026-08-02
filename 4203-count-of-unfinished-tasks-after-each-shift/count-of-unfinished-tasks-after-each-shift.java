class Solution {

    public int biSearch(int start,long sum,long[] prefixSum){
        int end=prefixSum.length-1;
        int pos=0;
        

        while(start<=end){
            int mid=start+(end-start)/2;

            if(prefixSum[mid]<=sum){
                pos=mid;
                start=mid+1;
            }else{
                end=mid-1;

            }



        }


        return pos;

    }



    public int[] countTasks(int[] tasks, int[] shifts) {
        int length=shifts.length;
        long[] prefixSum=new long[tasks.length];

        prefixSum[0]=tasks[0];
        for(int i=1;i<tasks.length;i++){
            prefixSum[i]=tasks[i]+prefixSum[i-1];
        }



        long sum=0;
        int start=0;
        int[] res=new int[length];

        for(int i=0;i<shifts.length;i++){
            int curr=shifts[i];
            sum+=curr;

            start=biSearch(start,sum,prefixSum);
            int remTasks=tasks.length-1-start;
            
            if(prefixSum[start]>sum){
                remTasks=tasks.length;
            }
            

            if(start==tasks.length-1){
                sum=0;
                start=0;
            }
                res[i]=remTasks;
        }




        return res;
        
    }
}