class Solution {
    public boolean digitCount(String num) {
       int[] freq=new int[10];
       for(int i=0;i<num.length();i++){
        freq[num.charAt(i)-'0']++;
       } 
       for(int i=0;i<num.length();i++){
        int comp=num.charAt(i)-'0';
        // System.out.println(comp+" comp"+freq[i]);
        if(comp!=freq[i]){
            return false;
        }
       }

       return true;
    }
}