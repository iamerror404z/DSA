class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int size=nums.length;
        int[] nextGreater=new int[size];
        Stack<Integer> stack=new Stack();

        for(int i=2*size-1;i>=0;i--){
        
        while(stack.size()!=0 && stack.peek()<=nums[i%size]){
                stack.pop();
            }
        
        if(stack.size()==0 && i<size){
            nextGreater[i]=-1;
        }else if(i<size){
            nextGreater[i]=stack.peek();
        }

            stack.push(nums[i%size]);


        }

        return nextGreater;
    }
}