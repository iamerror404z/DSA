class Solution {
    public int numSub(String s) {
        int length=s.length();
        int mod=(int)Math.pow(10,9)+7;
        
        
        int count=0;
        int start=0;
        for(int i=0;i<=length;i++){
            char curr=i==length?'0':s.charAt(i);
            
            if(curr=='0'){
                long windowSize=i-start;
                
                long windowSum=windowSize*(windowSize+1)/2;
   
                
                windowSum%=mod;
                count=(int)((count+windowSum)%mod);
                
                start=i+1;
            }
            
            
        }
        
        
        return count;
    }
}