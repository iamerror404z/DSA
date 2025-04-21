class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length()==1){return true;}
        String test1=word.toUpperCase();
        if(word.equals(test1)){return true;}
        String sub1=word.substring(1);
        String test2=sub1.toLowerCase();
        if(sub1.equals(test2)){return true;}
        return false;
    }
}