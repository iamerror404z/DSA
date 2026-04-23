class Solution {
    public long[] distance(int[] nums) {
        Map<Integer,long[]> map=new HashMap<>();
        int size=nums.length;

        for(int i=size-1;i>=0;i--){
            if(!map.containsKey(nums[i])){
                    map.put(nums[i],new long[4]);
            }
            long[] data=map.get(nums[i]);

            data[2]++;
            data[3]+=i;
        }

        long[] res=new long[size];

        
        for(int i=0;i<size;i++){
            long data[]=map.get(nums[i]);
            long sum=0;
            long left=0;
            long right=0;

            if(data[2]>1){
                data[2]--;
                data[3]-=i;

                left=data[3]-data[2]*i;
            }

            right=(data[0]*i)-data[1];



            data[0]++;
            data[1]+=i;


            res[i]=left+right;
            
        }



        return res;
        
    }
}