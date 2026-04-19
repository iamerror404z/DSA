class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque=new LinkedList<>();
        int length=nums.length;
        int[] res=new int[length-k+1];

        for(int i=0;i<length;i++){
            if(!deque.isEmpty() && deque.peekFirst()<=i-k){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekFirst()]<=nums[i]){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }

            deque.offerLast(i);

            if(i+1>=k){
                res[(i+1)-k]=nums[deque.peekFirst()];
            }
            

        }


        return res;
    
    }
}