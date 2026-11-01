class Solution {
    public int numOfDigits(int num){
        int size=0;

        while(num!=0){
            size++;
            num/=10;
        }

        return size;
    }

    public int minMergedInteger(int[] nums) {
        int min=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i+=2){
            int part1=nums[i];
            int part2=nums[i+1];

            int currNum=part1*(int)Math.pow(10,numOfDigits(part2))+part2;
            min=Math.min(min,currNum);
        }
        
        return  min;
    }
}