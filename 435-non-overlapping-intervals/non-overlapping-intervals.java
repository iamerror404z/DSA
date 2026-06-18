class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        MyComp mycomp=new MyComp();
        Arrays.sort(intervals,mycomp);

        for(int i[]:intervals){
            System.out.println(Arrays.toString(i));
        }

        int size=intervals.length;
        
        int remove=0;

        int[] prev=new int[2];
        prev[0]=intervals[0][0];
        prev[1]=intervals[0][1];

        for(int i=1;i<size;i++){
            int currStart=intervals[i][0];
            int currEnd=intervals[i][1];

            
            System.out.println("index is : "+i);
            System.out.println(Arrays.toString(prev));

            if(prev[1]>currStart){
                if(prev[1]<=currEnd){
                    // staty as it is
                }else{
                    prev[0]=currStart;
                    prev[1]=currEnd;
                }



                remove++;
            }else{
                prev[0]=currStart;
                prev[1]=currEnd;
            }

            
        }

      

        // System.out.println(remove);



        return remove;
    }
}


class MyComp implements Comparator<int[]>{
    @Override
    public int compare(int[] a,int b[]){
        if(a[0]!=b[0]){
            return a[0]-b[0];
        }

        return b[1]-a[1];
    }
}