class Solution {


    public int numOfDigits(int num){
        if(num<10){
            return 1;
        }else if(num<100){
            return 2;
        }else if(num<1000){
            return 3;
        }

        return 4;
}


    public void updateChars(char[] chars,char curr,int[] index,int freq){
        chars[index[0]++]=curr;

        if(freq==1){
            return ;
        }

        int size=numOfDigits(freq);
        
        
        index[0]+=size-1;


        for(int i=0;i<size;i++){
            int d=freq%10;

            char currD=(char)(48+d);
            chars[index[0]-i]=currD;


            freq/=10;
        }
        index[0]++;
        

        return;
        


        
    }
   
   public int compress(char[] chars) {
        char prev=chars[0];

        int[] end=new int[1];
        int freq=1;
        

        for(int i=1;i<chars.length;i++){
           char curr=chars[i];

           if(curr!=prev){
            updateChars(chars,prev,end,freq);

            freq=0;
           }
           
           freq++;
            prev=curr;
        }

        updateChars(chars,prev,end,freq);

   




        return end[0];
    }
}