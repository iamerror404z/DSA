class Solution {
    public void rotate(int[] nums, int k) {
       while(k>=nums.length){k=k-nums.length;}
        int pt=0;
        int p=nums.length-k;
        int[] pt1=Arrays.copyOfRange(nums,p,nums.length);
        int[] pt2=Arrays.copyOfRange(nums,0,p);
        for(int ii:pt1){
            nums[pt++]=ii;
        }for(int jj:pt2){
            nums[pt++]=jj;}
        System.out.println(Arrays.toString(nums));
    }
}
