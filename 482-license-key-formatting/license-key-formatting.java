class Solution {
    public String licenseKeyFormatting(String s, int k) {
        String ans="";
        String b=s.replace("-","");
        int len=b.length();
        char[] step=new char[len];
        int point=0;
        for (char ch:b.toCharArray()){
        if(ch>='a' && ch<='z'){
            char st=(char) (ch-32);
            step[point]=st;
            point++;}
        else{step[point++]=ch;}}
        int rem=len%k;
        int pt=0;
        if(k>=len){
            for (char cc:step){ans+=cc;} return ans;
        }
        if(rem==0){
            while(pt<len-k){
                for (int i=pt;i<pt+k;i++){
                    ans+=step[i];
                    // System.out.println(ans);
                }ans+='-';
                pt+=k;}
                
            for (int kk=pt;kk<pt+k;kk++){
                ans+=step[kk];
            }
        }else {
            for (int i=0;i<rem;i++){
                ans+=step[i];
            }ans+='-';
           
            pt+=rem;
            //  System.out.println(rem);
            while(pt<len-k){
                System.out.println(pt);
            for(int j=pt;j<pt+k;j++){
                ans+=step[j];
            }ans+='-';
                pt+=k;
        }for (int z=pt;z<len;z++){
            ans+=step[z];
        }}
    
        return ans;

}
}