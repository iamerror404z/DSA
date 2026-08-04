class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list=new ArrayList<>();
        int[] map=new int[101];

        int start=nums[0],end=nums[0];

        for(int i:nums){
            map[i]++;
            start=Math.min(start,i);
            end=Math.max(end,i);
        }

        for(int i=start+1;i<end;i++){
            if(map[i]==0){
                list.add(i);
            }
        }



        return list;
    }
}