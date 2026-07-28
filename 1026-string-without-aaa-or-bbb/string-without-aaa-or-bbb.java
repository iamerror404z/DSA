class Solution {

    public char[] buildWord(int ch1,int ch2,int cap1,int cap2){
        int length=cap1+cap2;
        char[] chars=new char[length];

        char[] charMap=new char[2];
        charMap[0]='a';
        charMap[1]='b';

        int curr=ch1;

        int[] rem=new int[2];

        if(ch1==0){
        rem[0]=cap1-1;
        rem[1]=cap2;
        }else{
            rem[1]=cap1-1;
            rem[0]=cap2;
        }

        int windowSize=1;

        for(int i=0;i<length;i++){
            chars[i]=charMap[curr];

            if(windowSize==2){
                curr=Math.abs(curr-1);
                windowSize=0;
            }else if(curr==ch1){
                if(rem[ch1]==0){
                    curr=ch2;
                    windowSize=0;
                }
                
            }else if(curr==ch2){
                int needed=(rem[ch1]/2)+(rem[ch1]%2)-1;

                if(!(rem[ch2]>needed)){
                    curr=ch1;
                    windowSize=0;
                }
            }
           
            rem[curr]--;
            windowSize++;
        }
        



        return chars;
    }


    public String strWithout3a3b(int a, int b) {
        if(a+b==0){
            return "";
        }


        char[] chars=null;

        if(a>=b){
            chars=buildWord(0,1,a,b);
        }else{
            chars=buildWord(1,0,b,a);
        }




        
        return new String(chars);
    }
}