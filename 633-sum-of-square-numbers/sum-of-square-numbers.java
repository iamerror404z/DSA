class Solution {
    public boolean judgeSquareSum(int c) {
        // we have already done with the binarysearch approach now moving forward to the two pointers
        int size=(int)Math.sqrt(c);
        long start=0;
        long end=size;

        while(start<=end){
            long currSum=(start*start)+(end*end);

            if(currSum==c){
                return true;
            }else if(currSum<c){
                start++;
            }else{
                end--;
            }
        }


        return false;
    }
}