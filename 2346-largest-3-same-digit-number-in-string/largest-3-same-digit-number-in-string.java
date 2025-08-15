class Solution {
    public String largestGoodInteger(String num) {
        char[] nums=num.toCharArray();
        int left=0;
        int right=0;
        char curr=' ';
        int max=0;
        String ans="";
        int len=nums.length;

        while(left<len){
            curr=nums[left];
            right=left;
            while(right<len-1 && curr==nums[right+1]){
                right++;
            }
            if(right-left+1>=3 &&curr>max){
                ans=num.substring(left,left+3);
                max=curr;
            }


            left=right+1;
        }


        return ans;
    }
}