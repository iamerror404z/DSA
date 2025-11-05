class Solution {
    public String firstPalindrome(String[] words) {
        
        for(String i:words){
            int left=0;
            int right=i.length()-1;
            while(left<right && i.charAt(left)==i.charAt(right)){

                left++;
                right--;
            }

            if(left>=right){
                return i;
            }
        }

        return "";
    }
}