class Solution {
    public int numTimesAllBlue(int[] flips) {
       int len=flips.length;
       char[] bits=new char[len];
       for(int i=0;i<len;i++){
        bits[i]='0';
       }
    
    int count=0;
    int right=0;
    int counter=0;
    for(int pos:flips){
        right=Math.max(right,pos);
        bits[pos-1]='1';
        if(1+counter==right){
            count++;
            counter++;
        }else{
            counter++;
        }
        
        }

       return  count; 
    }
}