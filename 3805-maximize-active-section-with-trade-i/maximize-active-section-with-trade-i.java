class Solution {
    
    public int[] slide(String s){
        int size=s.length();
        
        int[][] zero=new int[2][2];
        int[] one=new int[2];
        
        for(int i[]:zero){
            Arrays.fill(i,-1);
        }
        
        Arrays.fill(one,-1);
        
        int[] res=new int[3];
        Arrays.fill(res,-1);
        
        char prev='1';
        
        int start=0;
        
        
        for(int i=0;i<=size;i++){
    
            char curr=i<size?s.charAt(i):'1';
            
            if(curr!=prev){
                int end=i-1;
                
                if(prev=='1'){
                    if(zero[0][0]!=-1){
                        one[0]=start;
                        one[1]=end;
                        
                    }
                }else{
                    if(one[0]!=-1){
                        int tempSize=end-zero[0][0]+1;
                        
                        if(tempSize>res[2]){
                            res[2]=tempSize;
                            
                            res[0]=zero[0][0];
                            res[1]=end;
                        }
                        
                        
                        zero[0][0]=zero[1][0];
                        zero[0][1]=zero[1][1];
                        // updation part for the next cycle
                        Arrays.fill(one,-1);
                        zero[1][0]=-1;
                        zero[1][1]=-1;
                    }else{
                        
                        zero[0][0]=start;
                        zero[0][1]=end;
                    }
                    
                }
                
                
                
                start=i;
            }
            
            
            prev=curr;
        }
        
        
        // for(int i[]:zero){
        //     System.out.println(Arrays.toString(i));
        // }
        
        // System.out.println(Arrays.toString(one));
        
        return res;
        
    }

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