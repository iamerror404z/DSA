import java.util.Collections;
import java.util.LinkedList;

class Solution {
    public String customSortString(String order, String s) {
        char[] sort = order.toCharArray();
        char[]  word=s.toCharArray();
        String ans="";
        LinkedList<Character>  track= new LinkedList<>();
        // LinkedList<Integer> tack = new LinkedList<>();
        

        // Array.sort(sort);
        // Arrays.sort(word);

        for (char ts : sort) {
            for (int i = 0; i < word.length; i++) {
                if(ts==word[i]){
                    ans+=ts;
                    }}
            }
            for(char tp:s.toCharArray()){
                String ls=""+tp;
                if(!order.contains(ls)){
                    ans+=ls;}
                }
            
            
        // System.out.println(track);
        
        return ans;
    }
}