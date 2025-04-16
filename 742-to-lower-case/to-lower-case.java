class Solution {
    public String toLowerCase(String s) {
        String temp="";
        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch>='A' && ch<='Z' ){
                temp+=(char)(ch+32);
            }else{
                temp+=ch;
            }
        }return temp;
        
    }
}