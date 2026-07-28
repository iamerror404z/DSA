class Solution {

    public int movePointer(int[][] intervals,int start,int end){
        int max=Math.max(intervals[end][0],intervals[end][1]);

        while(start<end &&  max>intervals[start][1]){
            start++;
        }


        return Math.min(start,end-1);
    }


    public int removeCoveredIntervals(int[][] intervals) {
        MyComp comp=new MyComp();
        Arrays.sort(intervals,comp);
        int length=intervals.length;
        
        System.out.println("sorted arr is : ");
        
        for(int[] i:intervals){
            System.out.println(Arrays.toString(i));
        }

        int delete=0;
        int pointer=0;

        for(int i=1;i<length;i++){
            int currStart=intervals[i][0];
            int currEnd=intervals[i][1];

            pointer=movePointer(intervals,pointer,i);

            // System.out.println("i is : "+i+" pointer is : "+pointer);

            if(intervals[pointer][0]<=currStart && intervals[pointer][1]>=currEnd){
                delete++;
            }

            int prevStart=intervals[pointer][0];
            int prevEnd=intervals[pointer][1];

        }
        
        
         
        
        return length-delete;  
    }
}

class MyComp implements Comparator<int[]>{
    @Override
    public int compare(int a[],int[] b){
        
        if(a[0]!=b[0]){
            
            return a[0]-b[0];
        }
        
        
        return b[1]-a[1];
    }
}