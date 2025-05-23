class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums){
            int value=hm.getOrDefault(i,0);
            hm.put(i,value+1);
        }
        
        for(int j:hm.keySet()){
            if(hm.get(j)==1){
                return j;
            }
        }

        return 9999; 
    }
}