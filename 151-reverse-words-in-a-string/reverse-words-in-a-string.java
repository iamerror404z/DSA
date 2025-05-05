class Solution {
    public String reverseWords(String s) {
        char front;
        int count=0;
        for(int t=0;t<s.length();t++){
        front=s.charAt(t);
        if(front==' '){count++;}
        else{break;}}
        s=s.substring(count);
        String[] temp=s.split(" ");
        int len=temp.length;
        String ans="";
        for(int i=len-1;i>0;i--){
            System.out.println(i);
            String og=temp[i];
            String loc=(temp[i].replace(" ",""));
            // System.out.println(loc.length());
            ans+=loc;
            // System.out.println()
             if(!og.equals("")){
            ans+=" ";}
        } ans+=temp[0];
        
       return ans; }
}
