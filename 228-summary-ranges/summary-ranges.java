class Solution {
    public List<String> summaryRanges(int[] nums) {
        int left=0,right;
        int current;
        String move;
        List<String> ans=new ArrayList<>();
        int n=nums.length;
        while(left<n){
            right=left;
            current=nums[right];
            while(right<n-1 && current+1==nums[right+1] ){
                right+=1;
                current=nums[right];
            }
            if(left==right){
                move=String.valueOf(nums[left]);
                ans.add(move);
            }else{
                move=String.valueOf(nums[left])+"->"+String.valueOf(nums[right]);
                ans.add(move);
            }
            left=right+1;
        }
        return ans;
    }
}