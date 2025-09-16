class Solution {

    public int gcd(int a ,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }

    public int findGCD(int[] nums) {
        
        int min=Math.min(nums[0],nums[1]);
        int max=Math.max(nums[0],nums[1]);

        for(int i:nums){
            if(i<min){
                min=i;
            }
            if(i>max){
                max=i;
            }
        }



        return gcd(min,max);
    }
}