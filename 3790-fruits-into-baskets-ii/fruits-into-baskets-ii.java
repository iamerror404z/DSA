class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int count=0;
        int len=fruits.length;
        int pointer=0;
        for(int i=0;i<fruits.length;i++){
            pointer=0;
            while(pointer<len-1 && baskets[pointer]<fruits[i]){
                pointer++;
            }
            if(baskets[pointer]>=fruits[i]){
                count++;
                baskets[pointer]=-1;
            }
        }

        return fruits.length-count;

    }
}