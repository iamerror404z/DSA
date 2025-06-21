class Solution {
    public int findKOr(int[] nums, int k) {
        int size=nums.length;
        StringBuilder sb=new StringBuilder();
        int max=nums[0];
        for (int i:nums){
            if(i>max){
                max=i;
            }
        }
        int limit=Integer.toBinaryString(max).length();
        for (int i=31;i>=0;i--){
            int repeat=0;
            for (int num:nums){
                if((num&(1<<i))>0 ){
                    repeat++;
                }if(repeat>=k){
                    sb.append("1");
                     break;}
                }
                if(repeat<k){
                    sb.append("0");
                }
            }
        return Integer.parseInt(sb.toString(),2);
    }
}