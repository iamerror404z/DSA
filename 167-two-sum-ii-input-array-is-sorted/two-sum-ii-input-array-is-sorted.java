class Solution {

    public int binSearch(int[] arr,int target,int start,int end){

        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }

            if(arr[mid]>target){
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }


        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] pair=new int[2];
        int n=numbers.length;

        for(int i=0;i<n;i++){
            int pos=binSearch(numbers,target-numbers[i],i+1,n-1);
            if(pos!=-1){
                pair[0]=i+1;
                pair[1]=pos+1;

                return pair;
            }
        }

        
    
        return pair;
    }
}