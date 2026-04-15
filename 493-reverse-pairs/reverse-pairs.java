class Solution {

    public void sort(int start,int mid,int end,int nums[]){
        int size=end-start+1;
        int[] array=new int[size];

        int pointer1=start;
        int pointer2=mid+1;

        int index=0;
        
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

    public int countPairs(int[] nums,int start,int mid,int end){
        int upto=mid+1;
        int count=0;

        for(int i=start;i<=mid;i++){
            while(upto<=end && (long)nums[i]>2L*nums[upto]){
                upto++;
            }
        count+=(upto-mid-1);
        }

        return count;
    }


    public int divide(int start,int  end ,int[] nums){
       if(start>=end){
            return 0;
        }

        int mid=start+(end-start)/2;
        int part1Count=divide(mid+1,end,nums);
        int part2Count=divide(start,mid,nums);

        
        int currentCount=countPairs(nums,start,mid,end);
        sort(start,mid,end,nums);



        return part1Count+part2Count+currentCount;
    }   


    public int reversePairs(int[] nums) {
      

        return divide(0,nums.length-1,nums);
    }
}