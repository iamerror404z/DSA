class Solution {

    public int pollDigit(int[] digits,int pos){
        int pointer=0;

        for(int i=1;i<digits.length;i++){

            if(digits[i]!=0 && pointer==pos){
                digits[i]=0;

                return i;
            }

            if(digits[i]!=0){
                pointer++;
            }
        }


        return 10;
    }



    public String getPermutation(int n, int k) {
        char[] res=new char[n]; 
        int[] digits=new int[n+1];
        
        Arrays.fill(digits,1);

        int asc=(int)'0';

        int fact=1;

        for(int i=1;i<=n;i++){
            fact*=i;
        }
        
        int end=n;
        int target=k-1;


        for(int i=0;i<n;i++){;
            fact/=(end-i);

            int cycles=0;
            int nextTarget=0;

            cycles=target/fact;
            nextTarget=target%fact;
            
            char curr=(char)(asc+pollDigit(digits,0+cycles));
            res[i]=curr;

            // Sysydknefiwnwfi
            // ijnqidnwinfinw
            // jonfinfinqi2n


            target=nextTarget;
        }
        



        return new String(res);
    }
}