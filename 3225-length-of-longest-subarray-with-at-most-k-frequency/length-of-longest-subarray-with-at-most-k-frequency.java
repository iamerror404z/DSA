class Solution {
    public int updateStart(int start,int target,Map<Integer,int[]> map,int[] nums){
        int length=nums.length;
        int pos=0;

        for(int i=start;i<length;i++){
            int curr=nums[i];

            int[] arr=map.get(curr);
            arr[0]--;
            
            
            
            if(curr==target){
                pos=i+1;
                break;
            }

        }


        return pos;
    }


    public int maxSubarrayLength(int[] nums, int k) {
        int length=nums.length;
        Map<Integer,int[]> map=new HashMap<>();
        int max=0;

        int start=0;

        for(int i=0;i<length;i++){
            int curr=nums[i];

            if(!map.containsKey(curr)){
                map.put(curr,new int[1]);
            }

            int countArr[]=map.get(curr);
            int count=countArr[0]+1;
            countArr[0]=count;

            
            if(count>k){
                
                start=updateStart(start,curr,map,nums);
                
            }


            
            int end=i;
            max=Math.max(max,end-start+1);
        }




        return max;
    }
}