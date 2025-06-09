class Solution {
    public int[] evenOddBit(int n) {
        int[] bits=new int[2];

        for(int i=0;i<32;i++){
            int value=(n&(1<<i));
            if(i%2!=0 &&value>0)
                bits[1]++;
            else if(value>0)
                bits[0]++;
            
        }

        return bits;
        
    }
}