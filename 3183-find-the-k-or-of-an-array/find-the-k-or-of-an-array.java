class Solution {
    public int findKOr(int[] nums, int k) {
        int[] bit=new int[31+1];
        int size=nums.length;
        int loc=k-1;
        for (int i=0;i<=31;i++){
            int repeat=0;
            for (int num:nums){
                if((num&(1<<i))>0 ){
                    repeat++;
                }if(repeat>=k){
                     bit[31-i]=1;
                     break;
                }
            }
            
        }
        StringBuilder sb=new StringBuilder();
        for (int i:bit){
            sb.append(""+i);
        }
        int ans=Integer.parseInt(sb.toString(),2);
        return ans;
    }
}