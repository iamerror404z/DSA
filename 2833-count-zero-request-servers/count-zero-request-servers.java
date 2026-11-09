class Solution {

    public int lowerBound(int target,int[] queries,int x){
        int start=0;
        int end=queries.length-1;
        int res=-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            int high=queries[mid];
            int low=high-x;


            if(high<target){
                start=mid+1;
            }else{
                if(target>=low){
                    res=mid;
                }

                end=mid-1;
            }
            

          



        }
        
            return res;
    }

    public int upperBound(int target,int[] queries,int x){
        int start=0;
        int end=queries.length-1;
        int res=-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            int high=queries[mid];
            int low=high-x;
            
            
            
            // System.out.println(low+" : "+high+" : "+" : "+target);

            if(target<low){
                end=mid-1;
            }else{
                if(target<=high){
                    res=mid;
                }
                
                start=mid+1;
            }
            




        }
        
            return res;
    }

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int length=queries.length;

        Arrays.sort(logs,new MyComp());
        int[] ans=Arrays.copyOf(queries,queries.length);
        Arrays.sort(queries);

        int logSize=logs.length;


        // prev[0]--> prev server id 
        // prev[1]-->start
        // prev[2]->end

        int prevServer=-1;
        int prevEndIndex=-1;
        int[] slide=new int[length+1];

        for(int curr[]:logs){
            int currServer=curr[0];
            int currEnd=curr[1];

            if(currServer!=prevServer){
                prevEndIndex=-1;
            }

            




            int startIndex=lowerBound(curr[1],queries,x);
            int endIndex=upperBound(curr[1],queries,x);

            if(startIndex==-1 || endIndex==-1){
                continue;
            }

            int s=Math.max(prevEndIndex+1,startIndex);

            if(s>endIndex){
                continue;
            }
                startIndex=s;
            
                slide[startIndex]-=1;
                slide[endIndex+1]+=1;

                prevServer=currServer;
                prevEndIndex=endIndex;
            

        }
        // System.out.println(Arrays.toString(slide));
            

        // System.out.println(upperBound(4,queries,x));
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[length];

        int sum=n;
        for(int i=0;i<length;i++){
            
            sum+=slide[i];
            
            map.put(queries[i],sum);
        }

         for(int i=0;i<length;i++){
            
            int swap=map.get(ans[i]);
            ans[i]=swap;
        }

        


    


        return ans;
    }
}


class MyComp implements Comparator<int[]>{

    @Override
    public int  compare(int[] a,int[] b){
        if(a[0]!=b[0]){

            return a[0]-b[0];
        }

        return a[1]-b[1];
    }


}