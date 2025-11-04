class mycomp implements Comparator<int[]>{
    @Override
    public int compare(int[] a,int[] b){

        if(a[0]!=b[0]){
            return a[0]-b[0];
        }

        return a[1]-b[1];
    }
}


class Solution {

    public void answer(int[][] intervals,List<int[]> lst){

        int left=0,right=0,len=intervals.length;

        while(left<len){
            right=left;
            int start=intervals[left][0];
            int end=intervals[left][1];
            boolean flag=true;
            
            while(right<len && flag){
                flag=false;
                right++;
                if(right>=len){
                    break;
                }
                int locstart=intervals[right][0];
                int locend=intervals[right][1];
               
                if(locstart>=start && locstart<=end){
                System.out.println("right pos : "+right);
               System.out.println("loc start   : "+locstart);
               System.out.println("start : "+start+"\n\n"); 
              
                    flag=true;
                    start=Math.min(start,locstart);
                    end=Math.max(end,locend);
                    System.out.println();
                }
                if(locend>=start && locend<=end){
                    flag=true;
                    start=Math.min(start,locstart);
                    end=Math.max(end,locend);
                }
               
            }

             int[] interval={start,end};
            lst.add(interval);
            

            System.out.println(Arrays.toString(interval));
            System.out.println("left :"+left);
            System.out.println("left to be  : "+right);
            left=right;
            
        }


    }
    
    public int[][] merge(int[][] intervals) {
        List<int[]> list=new LinkedList<>();
        Comparator comp=new mycomp();

        Arrays.sort(intervals,comp);
        for(int[] i:intervals){
            System.out.println(Arrays.toString(i));
        }
        answer(intervals,list);

        int size=list.size();
        int[][] ans=new int[size][2];
        for(int i=0;i<size;i++){
            ans[i][0]=list.get(i)[0];
            ans[i][1]=list.get(i)[1];
        }

        return ans;   
    }
}