class Solution {

    public boolean rangeSearch(int low,int high,int[] arr){
        int start=0;
        int end=arr.length-1;
        int res=-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            int curr=arr[mid];

            if(curr<low){
                start=mid+1;
            }else{
                
                if(curr>=low && curr<=high){
                   
                   return true;
                }

                end=mid-1;
            }

        }

        

        return false;
    }

    

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res=0;

        for(int curr:arr1){

            int limit1=curr-d;
            int limit2=curr+d;

            int low=Math.min(limit1,limit2);
            int high=Math.max(limit1,limit2);



            if(!rangeSearch(low,high,arr2)){
                res++;

            }

        }


        return res;
    }
}