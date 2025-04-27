class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;
        for (int i:nums){
            int value=(map.getOrDefault(i,0))+1;
            map.put(i,value);
            System.out.println(value+" "+nums.length);
            if(value>(nums.length/2)){
                ans=i;return i;}}
        return ans;
    }
}