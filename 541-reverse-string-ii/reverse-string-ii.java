class Solution {
    public String reverseStr(String s, int k) {
        int pointer=0,upper=k,curr=0,lower=0;
        int limit=k;
        int len=s.length();
        StringBuilder ans=new StringBuilder();

        while(pointer<len){
            upper=Math.min(upper,len);
            curr=upper-1;
            while(curr!=lower-1){
                ans.append(s.charAt(curr));
                curr--;
            }
            lower=upper;
            curr=lower;
            upper=Math.min(curr+k,len);
            ans.append(s.substring(curr,upper));
            pointer=upper;
            lower=upper;
            upper=lower+k;
            

        }
        
        return ans.toString();
    }
}