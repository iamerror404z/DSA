class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> dup=new HashSet<>();
        ArrayList<Integer> ans=new ArrayList<>();
        int point=0;
        for (int ii:nums){
            if(!dup.contains(ii)){dup.add(ii);}
            else{ans.add(ii);}}
        return ans;}
        
    }
