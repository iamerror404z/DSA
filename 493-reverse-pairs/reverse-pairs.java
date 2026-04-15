class Solution {

    public void sort(int start,int mid,int end,int nums[],int count[]){
        int size=end-start+1;
        int[] array=new int[size];

        int pointer1=start;
        int pointer2=mid+1;

        int index=0;
        int upto=mid+1;

        for(int i=start;i<=mid;i++){
            while(upto<=end && (long)nums[i]>2L*nums[upto]){
                upto++;
            }

            count[0]+=(upto-mid-1);
            
        }

        while(pointer1<=mid && pointer2<=end){
            if(nums[pointer2]<=nums[pointer1]){
                array[index++]=nums[pointer2++];
            }else{
                array[index++]=nums[pointer1++];
            }
        }
        

        while(pointer1<=mid){
            array[index++]=nums[pointer1++];
        }

        while(pointer2<=end){
            array[index++]=nums[pointer2++];
        }

        for(int i=start;i<=end;i++){
            nums[i]=array[i-start];
        }

    }



    public void divide(int start,int  end ,int[] nums,int[] count){
        if(start>=end){
            return;
        }

        int mid=start+(end-start)/2;
        divide(mid+1,end,nums,count);
        divide(start,mid,nums,count);

        sort(start,mid,end,nums,count);





    }   


    public int reversePairs(int[] nums) {
        int count[]=new int[1];

        divide(0,nums.length-1,nums,count);
        return count[0];
    }
}