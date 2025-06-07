class Solution {
    public int findNonMinOrMax(int[] nums) {
        int min=101;
        int max=-1;
        for(int num:nums){
            if(num<min) min=num;
            if(num>max) max=num;
        }

        for (int i:nums){
            if(i!=min && i!=max){
                return i;
            }
        }

     return -1;   
    }
}