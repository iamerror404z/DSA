class Solution {
    public int sumOfUnique(int[] nums) {
        
        Set<Integer> od=new HashSet<>();
        for (int ik:nums){
            od.add(ik); }
        int count=0,sum=0;
        Arrays.sort(nums);
        for (int jj:od){
            for (int j=0;j<nums.length;j++){
                if (jj==nums[j]) {
                    count++;} }
                if (count==1){
                sum+=jj;}
                count=0; }
        return (sum);
    }
}