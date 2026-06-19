class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int max=1;
        int size=s.length();

        int start=0;
        int prev=-1;


        for(int i=1;i<size;i++){
            int currChar=s.charAt(i);
            int prevChar=s.charAt(i-1);

            if(currChar==prevChar){
                if(prev==-1){
                    prev=i;
                }else{
                    start=prev;
                    prev=i;
                }
            }

            max=Math.max(max,i-start+1);

        }





        return max;
    }
}