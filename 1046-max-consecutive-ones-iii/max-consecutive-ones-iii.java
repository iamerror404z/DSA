class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0;
        Queue<Integer> queue=new LinkedList<>();
        int size=nums.length;
        int start=0;

        int pointer=0;
        
        for(int i=0;i<size && k==0;i++){
            if(nums[i]==1){
                pointer=i;
                
                while(pointer<size && nums[pointer]==1){
                    pointer++;
                }
                
                max=Math.max(max,pointer-i);

                i=pointer;
            }
        }

        if(k==0){
            return max;
        }
        

        for(int i=0;i<size;i++){
            

            if(nums[i]==0){
                if(queue.size()>=k &&k>0){
                    start=queue.poll()+1;
                }
                queue.add(i);
            }

            max=Math.max(max,i-start+1);

        }




        return max;
    }   
}