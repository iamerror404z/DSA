class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int ans[]=Arrays.copyOfRange(nums,0,2*n);

        for(int i=n;i<2*n;i++){
            ans[i]=ans[i-n];
        }

        return ans;
        
    }
}