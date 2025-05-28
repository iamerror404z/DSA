class Solution {
    public int findLucky(int[] arr) {
        int left=0;
        int right;
        int size=arr.length;
        int ans=-1;
        Arrays.sort(arr);
        while(left<size){
            int current=arr[left];
            right=left;
            while(right<size-1 &&arr[right+1]==current){
                right++;
            }
            if(right-left+1==current && current>ans){
                ans=current;
            }
            left=right+1;
        }

        return ans;
    }
}