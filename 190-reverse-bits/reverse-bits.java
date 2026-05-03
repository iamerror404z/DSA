class Solution {
    public int reverseBits(int n) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<32;i++){
            int shift=1<<i;
            int d=(n & shift);
            if(d!=0){
                sb.append(1);
            }else{
                sb.append(0);
            }
        }

        System.out.println(sb.toString());

        return Integer.parseInt(sb.toString(),2);
    }
}