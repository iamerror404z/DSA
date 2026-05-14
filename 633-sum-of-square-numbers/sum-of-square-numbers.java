class Solution {


    public int biSearch(int target,int start,int end){

        while(start<=end){
            int mid=start+(end-start);

            if(mid*mid==target){
                return mid;
            }

            if(mid*mid>target){
                end=mid-1;
            }else{
                start=mid+1;
            }

        }




        return -1;
    }


    public boolean judgeSquareSum(int c) {
        if(c==0){
            return true;
        }

        int size=(int)Math.sqrt(c);
        System.out.println(size);

       for(int i=0;i<=size;i++){
        int curr=i*i;
        int required=c-curr;
        int found=biSearch(required,i,size);

        if(found!=-1){
            return true;
        }

        // System.out.println("num is : "+i+"   rquired is : "+found);
       }

        return false;
    }
}