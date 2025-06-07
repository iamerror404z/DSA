class Solution {
    public String replaceDigits(String s) {
        int len=s.length();
        StringBuilder sb=new StringBuilder();
        char prev;
        for(int i=0;i<len;i++){
            if(i%2==0){
                sb.append(s.charAt(i));
            }else{
                int pos=s.charAt(i)-'0';
                char ch=(char)(s.charAt(i-1)+pos);
                sb.append(ch);
            }
        }

        return sb.toString();
        
    }
}