class Solution {
    public int hammingWeight(int n) {
        int count=0;

        for(int i=0;i<=31;i++){
            int bit=(1<<i);
            if((n&bit)>0){
                count++;
            }
        }

        
        return count;
    }
}