class Solution {
    public boolean hasAllCodes(String s, int k) {
        if(s.length()<k){
            return false;
        }

        int MAX=Integer.MAX_VALUE;

        int size=(MAX>>(31-k));
        

        int []map=new int[size+1];


        int num=0;    
    


        for(int i=0;i<k;i++){
            num=(num<<1);
            if(s.charAt(i)=='1'){
                num=num|1;
            }
        }

        map[num]=1;

        for(int i=k;i<s.length();i++){
            int start=i-k;
            if(s.charAt(start)=='1'){
                num=num-(int)Math.pow(2,k-1);
            }
            num=(num<<1);
            num+=(s.charAt(i)-'0');

            
            map[num]=1;}


        

        for(int i:map){
            if(i!=1){
                return false;
            }
        }




        return true;
        
    }
}