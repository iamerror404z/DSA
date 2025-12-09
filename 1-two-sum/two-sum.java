class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] pair=new int[2];

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                pair[0]=map.get(nums[i]);
                pair[1]=i;
                return pair;
            }
            map.put(target-nums[i],i);
        }

        return pair;  
    }
}