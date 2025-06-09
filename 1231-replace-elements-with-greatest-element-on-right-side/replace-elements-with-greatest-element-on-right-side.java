class Solution {
    public int[] replaceElements(int[] arr) {
        int len=arr.length;
        int[] max=new int[len];
        max[len-1]=-1;
        for(int i=len-2;i>=0;i--){
            
            max[i]=Math.max(arr[i+1],max[i+1]);
            
        }

        return max;
    }
}