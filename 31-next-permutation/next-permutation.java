
class Solution {
    
    
    public void swapArr(int[] nums,int start){
        int length=nums.length;
        int end=length-1;
        
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            
            start++;
            end--;
        }
        
        return ;
    }
    
    public int minPos(int[] nums,int end,int target){
        int[] pos=new int[2];
        pos[1]=Integer.MAX_VALUE;
        
        
        
        for(int i=nums.length-1;i>=end;i--){
            int curr=nums[i];
            
            if(curr>target && curr<pos[1]){
                pos[1]=curr;
                pos[0]=i;
            }
        }
        
        return pos[0];
        
    }
    
    
    public void nextPermutation(int[] nums) {
       int length=nums.length;
       int max=nums[length-1];


       for(int i=length-2;i>=0;i--){
        int curr=nums[i];

        if(curr<max){
            // swap the curr with the element whihc ic max than curr and min among all the possiblities
            int swapIndex=minPos(nums,i,curr);
            nums[i]=nums[swapIndex];
            nums[swapIndex]=curr;


            swapArr(nums,i+1);
            return ;
        }


        max=Math.max(max,curr);

       }


        Arrays.sort(nums);

        return;
    }
}