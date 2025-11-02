class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> lst=new LinkedList<>();
        Arrays.sort(nums);
    
    
        for(int i=0;i<nums.length-1;i++){
            int next=nums[i]+1;
            while(next!=nums[i+1]){
                lst.add(next++);

            }
        }
        
        
        return lst;
    }
}