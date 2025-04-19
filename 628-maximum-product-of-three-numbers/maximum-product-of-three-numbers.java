class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int neg=0,point=0;
        int lm=0,step=Integer.MIN_VALUE;
        while(neg<3 && point<nums.length){
            if(nums[point++]<0){neg++;}}
        if(neg>=2){
             step=nums[0]*nums[1];
        step*=nums[nums.length-1];}
        int pro=1;
        for(int i=nums.length-1;i>=nums.length-3;i--){
            pro*=nums[i];
        }if(step>pro){pro=step;}
        return (pro);
        
    }
}