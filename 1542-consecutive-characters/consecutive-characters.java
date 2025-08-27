class Solution {
    public int maxPower(String s) {
        int max=0;

        int left=0;
        int right=0;
        int len=s.length();
        while(left<len){
            right=left;
            char curr=s.charAt(left);

        while(right<len-1 && s.charAt(right+1)==curr){
            right++;
        }
        if(right-left+1>max){
            max=right-left;
        }


        left=right+1;
        }




        return max+1;
    }
}