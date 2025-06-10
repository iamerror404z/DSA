class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int position1=0;
        int position2=0;
        
        if(t.length()<s.length()){
            return false;
        }

        while(position1<s.length()){
            char ch1=s.charAt(position1);
            while(position2<t.length()-1 && t.charAt(position2)!=ch1){
                position2++;
            }
            if(position2>=t.length()){
                return false;
            }

            if(ch1!=t.charAt(position2)){
                return false;}

            position2++;
            position1++;
        }

        return true;
    }
}