class Solution {

    public boolean is132(int left,int curr,int right){
        if(left<right && right<curr){
            return true;
        }

        return false;
    }

    public boolean sort(int[][] arr,int start,int mid,int end){
        int size=end-start+1;
        int[][] temp=new int[size][2];
        boolean flag=false;

        int pointer1=start;
        int pointer2=mid+1;
        int index=0;

        while(pointer1<=mid && pointer2<=end){
            if(arr[pointer1][0]>arr[pointer2][0]){
                temp[index][0]=arr[pointer1][0];
                temp[index][1]=arr[pointer1][1];

                flag=flag || is132(temp[index][1],temp[index][0],arr[pointer2][0]);

                pointer1++;
                index++;
            }else{
                temp[index][0]=arr[pointer2][0];
                temp[index][1]=arr[pointer2][1];
                pointer2++;
                index++;
            }
        }

        while(pointer1<=mid){
                temp[index][0]=arr[pointer1][0];
                temp[index][1]=arr[pointer1][1];

                flag=flag || is132(temp[index][1],temp[index][0],arr[mid+1][0]);
                pointer1++;
                index++;
        }

        while(pointer2<=end){
            temp[index][0]=arr[pointer2][0];
            temp[index][1]=arr[pointer2][1];
            pointer2++;
            index++;
        }


        for(int i=0;i<size;i++){
            arr[start+i][0]=temp[i][0];
            arr[start+i][1]=temp[i][1];
        }




        return flag;
    }

    public boolean mergeSort(int[][] arr,int start,int end){
        if(start>=end){
            return false;
        }

        int mid=start+(end-start)/2;

        boolean right=mergeSort(arr,mid+1,end);
        boolean left=mergeSort(arr,start,mid);

        boolean curr=sort(arr,start,mid,end);


        return right || curr || left;
    }


    public boolean find132pattern(int[] nums) {
        int size=nums.length;
        int[][] arr=new int[size][2];
        arr[0][0]=nums[0];
        arr[0][1]=Integer.MAX_VALUE;

        for(int i=1;i<size;i++){
            arr[i][0]=nums[i];
            arr[i][1]=Math.min(arr[i-1][1],nums[i-1]);
        }

   

        return mergeSort(arr,0,size-1);

    }
}