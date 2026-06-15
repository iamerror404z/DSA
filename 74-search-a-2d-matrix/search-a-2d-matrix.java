class Solution {
    public int[] indexSerializer(int curr,int colSize){
        int[] res=new int[2];

        res[0]=curr/colSize;
        res[1]=curr%colSize;

        return res;
    }


    public boolean binarySearch(int target,int[][] mat){
        int start=0;

        int rowSize=mat.length;
        int colSize=mat[0].length;

        int end=rowSize*colSize;
        end--;

        while(start<=end){
            int mid=start+(end-start)/2;

            int[] pos=indexSerializer(mid,colSize);

            int currElement=mat[pos[0]][pos[1]];

            // System.out.println("mid is : "+mid);
            // System.out.println(currElement);

            if(currElement>target){
                end=mid-1;
            }else if(currElement==target){
                return true;
            }else{
                start=mid+1;
            }
        }






        return false;
    }






    public boolean searchMatrix(int[][] matrix, int target) {
       
       boolean res=binarySearch(target,matrix); 


       return res;
    }
}