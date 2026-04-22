class Solution {
    public int binarySearchStart(int[][] intervals,int target){
        int start=0;
        int end=intervals.length-1;
        int index=0;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(target>=intervals[mid][0] && target<=intervals[mid][1]){
                return mid;
            }else if(intervals[mid][0]>target){
                end=mid-1;
            }else{
                index=mid;
                start=mid+1;
            }
        }

    
       


        return index;
    }



    public int binarySearchEnd(int[][] intervals,int target){
        int start=0;
        int length=intervals.length;
        int end=intervals.length-1;
        int index=0;

        while(start<=end){
            int mid=start+(end-start)/2;

            
            if(target>=intervals[mid][0] && target<=intervals[mid][1]){
                // System.out.println("ans is ");
                return mid;
            }else if(intervals[mid][0]>target){
                end=mid-1;
            }else{
                index=mid;
                start=mid+1;
            }

        }

            return index;
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length=intervals.length;
        if(length==0){
            int[][] res=new int[1][2];
            res[0][0]=newInterval[0];
            res[0][1]=newInterval[1];
            return res;
        }
        int startingPoint=binarySearchStart(intervals,newInterval[0]);
        System.out.println("Starting point is :"+startingPoint);
        int endingPoint=binarySearchEnd(intervals,newInterval[1]);
        System.out.println("end is :"+endingPoint);

        boolean hasOverlap=false;

        
        int min=newInterval[0];
        int max=newInterval[1];
        
        boolean bothOverlap=false;
        if(newInterval[0]<=intervals[startingPoint][1]){
            hasOverlap=true;
            min=Math.min(intervals[startingPoint][0],min);

        }else{
            startingPoint++;
        }

        if(newInterval[1]>=intervals[endingPoint][0]){
            hasOverlap=true;
            max=Math.max(max,intervals[endingPoint][1]);
        }else{
            endingPoint--;
        }


        int middle=1;
        
        

        int left=startingPoint;
        int right=length-(endingPoint+1);
        int size=left+right+middle;
        System.out.println("left size is :"+left);
        System.out.println("right is : "+right);
        System.out.println("size is :"+size);

        int[][] res=new int[size][2];
        int index=0;

        for(int i=0;i<startingPoint;i++){
            res[index][0]=intervals[i][0];
            res[index++][1]=intervals[i][1];
        }

        res[index][0]=min;
        res[index++][1]=max;


        for(int i=endingPoint+1;i<length;i++){
            res[index][0]=intervals[i][0];
            res[index++][1]=intervals[i][1];
        }



    


        return res;
    }
}