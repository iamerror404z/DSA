class Solution {
    public int largestInteger(int[] nums, int k) {
        int[] map=new int[51];
        int max=-1;

        for(int i:nums){
            map[i]++;
            max=Math.max(max,i);
        }

        if(k==nums.length){
            return max;
        }

        max=-1;
        if(k==1){
            for(int i=1;i<=50;i++){
                if(map[i]==1){
                    max=Math.max(max,i);
                }
            }

            return max;
        }



        int length=nums.length;
        if(Math.min(map[nums[0]],map[nums[length-1]])>=2){
            return -1;
        }

        if(map[nums[length-1]]>=2){
            return nums[0];
        }else if(map[nums[0]]>=2){
            return nums[length-1];
        }


        return Math.max(nums[0],nums[length-1]);

    }
}