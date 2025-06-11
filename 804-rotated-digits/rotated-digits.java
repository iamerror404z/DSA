class Solution {
    public int rotatedDigits(int n) {
        int count=0;
        int[] map=new int[10];
        map[2]=5;
        map[5]=2;
        map[6]=9;
        map[9]=6;

        for(int i=1;i<=n;i++){
            int b=i;
            int dig;
            int changes=0;
            while(b!=0){
                dig=b%10;
                b/=10;
                if(dig==3 || dig==4|| dig==7){
                    changes=-1;
                    break;
                }
                if(map[dig]!=0){
                    changes++;
                }
            }
            if(changes>=1){
                count++;
            }
        }

        return count;
    }
}