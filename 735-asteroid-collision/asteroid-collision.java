class Solution {

   
    public boolean isTrue(int num,Stack<Integer> stack){
        int curr =num;
        int prev=stack.peek();

        int currSign=curr>=0?1:-1;
        int prevSign=prev>=0?1:-1;

        if(currSign+prevSign!=0){
            return false;
        }


        return true;
    }


    public void updateStack(int curr,Stack<Integer> stack){
       
       if(curr>=0){
        stack.push(curr);
        return;
       }
        
        while(!stack.isEmpty() && isTrue(curr,stack)){
            int prevAbs=Math.abs(stack.peek());
            int currAbs=Math.abs(curr);
            
            if(prevAbs==currAbs){
                stack.pop();

                return;
            }else if(prevAbs>currAbs){
                return;
            }else{
                stack.pop();
            }

        }

        stack.push(curr);


    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<asteroids.length;i++){
            int curr = asteroids[i];
            updateStack(curr,stack);
            

        }

        int[] res = new int[stack.size()];

        int size=stack.size();
        for(int i=size-1;i>=0;i--){
            res[i]=stack.pop();
        }






        
        return res;
    }
}