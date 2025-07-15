class Solution {
    public boolean validMountainArray(int[] arr) {
        int len=arr.length;
        if(len<3){
            return false;
        }
        int pointer=0;
        while(pointer<len-1 && arr[pointer]<arr[pointer+1]){
            pointer++;
        }
        if(pointer==0 || pointer==len-1){
            return false;
        }
        
        while(pointer<len-1 && arr[pointer]>arr[pointer+1]){
            pointer++;
        }


        return pointer==len-1;
    }
}