class Solution {
    public int singleNumber(int[] nums) {
        int ans=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i:nums){
            int value=map.getOrDefault(i,0);
            map.put(i,value+1);}
        for (int j:nums){
            if(map.get(j)==1){ans=j;}
        }
        return ans;
    }
}