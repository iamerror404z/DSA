class Solution {

    public int numOfDigits(int num){
        int b=num;
        int size=0;

        while(b!=0){
            b/=10;
            size++;
        }

        return size;

    }


    public static void recursion(long[] prev,int[] limits,
    long highCut,List<Integer> list){
        
     
     if(prev[1]>limits[2] || prev[0]>limits[1]){
        
         return ;
     }
     

     
     if(prev[0]>=limits[0] && prev[0]<=limits[1] && prev[1]==limits[2]){
         list.add((int)prev[0]);
     }

     
     
     
     long currD=(prev[0]%10)+1;
     long currNum=prev[0]*10;
     
     
     if(currD>9){
        
         return;
     }
     currNum+=currD;
     
     long curr[]=new long[]{currNum,prev[1]+1};
     
     recursion(curr,limits,highCut/10,list);
     
     
     
    
    
}



    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list=new LinkedList<>();

        int lowDigits=numOfDigits(low);
        int highDigits=numOfDigits(high);


        long highCut=(long)Math.pow(10,highDigits-1);

        int limits[]=new int[]{low,high,highDigits};


    for(int j=lowDigits;j<=highDigits;j++){
        limits[2]=j;

        for(long i=1;i<=9;i++){
            long[] pass=new long[]{i,1};
            recursion(pass,limits,highCut/10,list);
        }
    } 

        
       return list;
    }
    
}