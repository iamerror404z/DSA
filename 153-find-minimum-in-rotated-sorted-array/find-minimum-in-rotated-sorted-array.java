class Solution {
    public int binarySearch(int[] nums){
        int start=0;
        int end=nums.length-1;
        int minIndex=0;

        while(start<=end){
            int mid=start+(end-start)/2;

            if(nums[start]<=nums[mid]){
                if(nums[start]<nums[minIndex]){
                    minIndex=start;
                }
                start=mid+1;
            }else{
                if(nums[mid]<=nums[minIndex]){
                    minIndex=mid;
                }

                end=mid-1;
            }


        }



        return minIndex;
    }

    public int findMin(int[] nums) {
    
        return nums[binarySearch(nums)];
    }
}