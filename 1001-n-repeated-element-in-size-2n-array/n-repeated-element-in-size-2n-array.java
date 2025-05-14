class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer,Integer> hsmap=new HashMap<>();
        int point=nums.length/2;
        for (int num:nums ){
            int repeat=hsmap.getOrDefault(num,0);
            repeat++;
            hsmap.put(num,repeat);
            if(repeat==point){
                return num;
            }
        }
        return 0;

    }
}