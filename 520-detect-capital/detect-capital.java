class Solution {
    public boolean detectCapitalUse(String word) {
        int  n=word.length();
        if(n==1){return (true);}
        int pos=1;
        // boolean pos=word.charAt(0);
        boolean up=Character.isUpperCase(word.charAt(0));
        boolean cap=true;
        while((up|| cap)&& (pos<n)){
            up=up&&Character.isUpperCase(word.charAt(pos));
            cap=cap&&Character.isLowerCase(word.charAt(pos));
            // System.out.println(up +"    "+ cap);
            pos++;}
        return(up || cap);
    }
}