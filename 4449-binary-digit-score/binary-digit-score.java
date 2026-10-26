class Solution {
    public int countBits(int a){
        int count=0;
        int shift=1;

        
        
        for(int i=1;i<31;i++){
            if((a&shift)!=0){
                count++;
            }
            shift=shift<<1;
        }

        return count;
    }


    public int calculateScore(int a, int b) {
        int bitCount1=countBits(a);
        int bitCount2=countBits(b);

        return bitCount1>=bitCount2?bitCount1*bitCount2:bitCount2/bitCount1;
    }
}