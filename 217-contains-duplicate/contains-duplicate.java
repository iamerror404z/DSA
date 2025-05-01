class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer ,Integer> map=new HashMap<>();
        for (int ii:nums){

            int step=map.getOrDefault(ii,0);
            step+=1;
            if(step==2){return true;}
            map.put(ii,step);
        }
        return false;
    }
}