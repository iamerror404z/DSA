class Solution {
    public int subarraySum(int[] nums, int k) {
       int count=0;

        int prefixSum=0;
        Map<Integer,Integer> map =new HashMap<>();
        map.put(0,1);

        for(int curr:nums){
            
            prefixSum+=curr;
            int target=prefixSum-k;

            if(map.containsKey(target)){
                count+=(map.get(target));
            }

            
            int temp=map.getOrDefault(prefixSum,0);
            map.put(prefixSum,temp+1);

        }





        return count;
    }
}