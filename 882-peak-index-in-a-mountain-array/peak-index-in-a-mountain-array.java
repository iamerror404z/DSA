class Solution {

    public int binarySearchLinear(int[] arr){
        int start=0;
        int end=arr.length-1;
        int length=arr.length;
        int mountainIndex=0;

        while(start<=end){
            int mid=start+(end-start)/2;

            int prev=mid-1>=0?arr[mid-1]:-1;
            int next=mid+1<length?arr[mid+1]:-1;


            if(arr[mid]>prev && arr[mid]>next){
                
                return mid;
            }

            if(next>arr[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }}


            
        


        return mountainIndex;}
    


    




    public int peakIndexInMountainArray(int[] arr) {
        int index=binarySearchLinear(arr);


        return index;

    }
}