class Solution {
    public boolean areNumbersAscending(String s) {
        List<Integer> nums=new LinkedList<Integer>();
        String[] parts=s.split(" ");
        int non=0;
        for(int i=0;i<parts.length;i++){
            try{
                int temp=Integer.parseInt(parts[i]);
                nums.add(temp);
            }catch (Exception e){
                non++;
            }
        }
        
        
        for(int i=1;i<nums.size();i++){
            if(nums.get(i)<=nums.get(i-1)){
                return false;
            }
        }




        return true;
    }
}