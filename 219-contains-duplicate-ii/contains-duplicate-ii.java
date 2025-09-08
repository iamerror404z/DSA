class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,List<Integer>> map=new HashMap<Integer,List<Integer>>();

        for(int i=0;i<nums.length;i++){
            if(map.keySet().contains(nums[i])){
                map.get(nums[i]).add(i);

            }else{
                List<Integer> lst=new LinkedList<Integer>();
                lst.add(i);
                map.put(nums[i],lst);

            }
        } 
        
        for(int i:map.keySet()){
            if(map.get(i).size()>=2){
                boolean step=false;
                for(int j=1;j<map.get(i).size();j++){
                    if(Math.abs(map.get(i).get(j)-map.get(i).get(j-1))<=k){
                        step=true;
                        break;
                    }
                }
                if(step){
                    return step;
                }
            }
        }


        return false;
    }
}