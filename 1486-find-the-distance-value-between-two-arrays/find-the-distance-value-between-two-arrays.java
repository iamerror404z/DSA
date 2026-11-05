class Solution {

    public int findLowerBound(int low,int high,int[] arr){
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
                    res=mid;
                }

                end=mid-1;
            }

        }

        

        return res;
    }

    public int findUpperBound(int low,int high,int[] arr){
        int start=0;
        int end=arr.length-1;
        int res=-1;

        while(start<=end){
            int mid=start+(end-start)/2;

            int curr=arr[mid];

            if(curr>high){
                end=mid-1;
            }else{
                if(curr>=low && curr<=high){
                    res=mid;
                }

                start=mid+1;
            }


        }

        

        return res;
    }


    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res=0;

        for(int curr:arr1){
            // lets calculate the the num of elements in negValue

            int limit1=curr-d;
            int limit2=curr+d;

            int low=Math.min(limit1,limit2);
            int high=Math.max(limit1,limit2);


            int lowIndex=findLowerBound(low,high,arr2);
            int highIndex=findUpperBound(low,high,arr2);


            if(lowIndex==-1){
                res++;

            }

        }


        return res;
    }
}