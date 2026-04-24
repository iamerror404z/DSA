class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int left=0;
        int right=0;
        int any=0;

        for(char ch:moves.toCharArray()){
            if(ch=='L'){
                left++;
            }else if(ch=='R'){
                right++;
            }else{
                any++;
            }
        }


        return Math.max(left,right)+any-Math.min(left,right);

       
    }
}