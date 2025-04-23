class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count=1;
        for (int i:arr){
            if (i%2!=0){count++;
            if(count>3){break;}}
            if(i%2==0){count=1;}}

        return count>3;
    }
}