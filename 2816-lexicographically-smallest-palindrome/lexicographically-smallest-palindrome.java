class Solution {
    public String makeSmallestPalindrome(String s) {
      int mid=s.length()/2;
      int left=0;
      int right=s.length()-1;
      char[] ch=new char[s.length()];
      
      for(int i=0;i<s.length();i++){
        ch[i]=s.charAt(i);
      }

      while(left<mid){
        if(ch[left]!=ch[right]){
            if(ch[left]<ch[right]){
                ch[right]=ch[left];}
            else{
                ch[left]=ch[right];}}
            left++;
            right--;
            
        }
        StringBuilder step=new StringBuilder();

        for(char c:ch){
            step.append(c);
        }

        return step.toString();
    }
}