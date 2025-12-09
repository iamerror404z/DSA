class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;
        int[] pair=new int[2];
        
        while(numbers[left]+numbers[right]!=target){
            if(numbers[left]+numbers[right]>target){
                right--;
            }else{
                left++;
            }
        }

        pair[0]=left+1;
        pair[1]=right+1;
        
        return pair;
    }
}