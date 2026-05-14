class Solution {
    public boolean find132pattern(int[] nums) {
        // we have already done with binarey seacrh now we are going to apply stack for this one 
        Stack<Integer> stack=new Stack<>();
        int size=nums.length;
        int min[]=new int[size];
        min[0]=nums[0];

        for(int i=1;i<size;i++){
            min[i]=Math.min(min[i-1],nums[i]);
        }

        System.out.println(Arrays.toString(min));

        for(int i=size-1;i>=0;i--){
            int left=min[i];
            int curr=nums[i];

            while(!stack.isEmpty() && stack.peek()<=left){
                stack.pop();
            }

            int right=!stack.isEmpty()?stack.peek():Integer.MAX_VALUE;

            if(left<right && right<curr){
                return true;
            }

            stack.push(curr);

        }




        return false;
    }
}