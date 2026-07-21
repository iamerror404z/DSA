class Solution {
    
  public int maxActiveSectionsAfterTrade(String s) {
        int size=s.length();

        int start=0;
        int prev=1;
        boolean hasOne=false;
        int prevOnes=0;

        int totalSum=0;
        int max=0;
        int zero=-1;

        for(int i=0;i<=size;i++){
            int curr=i<size?s.charAt(i)-'0':1;
            
            if(curr!=prev){
                int newStart=i;
                int end=i-1;
                if(prev==0){
                    if(hasOne){
                        int netProfit=(i-zero)-prevOnes;
                        max=Math.max(max,netProfit);


                        zero=start;
                        hasOne=false;
                    }else{
                        zero=start;
                    }


                }else if(zero!=-1){
                    hasOne=true;
                    prevOnes=i-start;
                                    
                  }


                start=newStart;
                }
            

            totalSum+=curr;
            prev=curr;
        }

        // System.out.println(max+totalSum-1);

       
        return max+totalSum-1;
    }
}