class Solution {
    public void reverseString(char[] s) {
        int mid=s.length/2;
        int pos=s.length-1;
        char temp;
        for (int i=0;i<mid;i++){
            temp=s[i];
            s[i]=s[pos];
            s[pos]=temp;
            pos--;
        }
        
    }
}