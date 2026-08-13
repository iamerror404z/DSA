class Solution {

    public int fixEnd(int m1){
        
        return m1-(m1%15);

    }

    public int fixStart(int m1){
        int rem=m1%15;

        if(rem==0){
            return m1;
        }

        return m1+(15-rem);
    }



    public int numberOfRounds(String loginTime, String logoutTime) {
        int h1=Integer.parseInt(loginTime.substring(0,2));
        int m1=Integer.parseInt(loginTime.substring(3,5));
        
        int h2=Integer.parseInt(logoutTime.substring(0,2));
        int m2=Integer.parseInt(logoutTime.substring(3,5));

        // fix the values;
        
        int matches=0;

        if(h2<h1 || (h2==h1 && m2<m1)){
            m1=fixStart(m1);
            m2=fixEnd(m2);
            int day1=(24*60)-(h1*60)-m1;
            int day2=(h2*60)+m2;
            int total=day1+day2;
            matches=(day1+day2)/15;
        }else{
            
            m1=fixStart(m1);
            m2=fixEnd(m2);
            int end=(h2*60)+m2;
            int start=(h1*60)+m1;

            matches=(end-start)/15;
            matches=Math.max(matches,0);
        }



        return matches;
    }
}