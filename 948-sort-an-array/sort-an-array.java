class Solution {


    public void sort(int[] nums,int low,int mid,int high){
        ArrayList<Integer> lst=new ArrayList<>();
        int pointer1=low;
        int pointer2=mid;
        while(pointer1<mid && pointer2<=high){
            if(nums[pointer1]<=nums[pointer2]){
                lst.add(nums[pointer1]);
                pointer1++;
            }else{
                lst.add(nums[pointer2]);
                pointer2++;
            }
        }

        while(pointer1<mid){
            lst.add(nums[pointer1++]);
        }
        while(pointer2<=high){
            lst.add(nums[pointer2++]);
        }
        for(int i=0;i<lst.size();i++){
            nums[low+i]=lst.get(i);
        }
    }
    public void mergeSort(int[] nums,int low,int high){
        if(low==high){
            return ;
        }
        int mid=low+(high-low)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);

        sort(nums, low ,mid+1, high);
    }
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
}