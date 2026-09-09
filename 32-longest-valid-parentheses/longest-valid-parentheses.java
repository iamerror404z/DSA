class Solution {

    
    public  void valid(String s,int[] res){
        Stack<Integer> stack=new Stack<>();
        int max=0;
        
        for(int i=0;i<s.length();i++){
            char curr= s.charAt(i);
            
            if(curr=='('){
                stack.push(i);
            }else{
                if(!stack.isEmpty() && s.charAt(stack.peek())=='('){
                    res[stack.pop()]=1;
                    res[i]=1; 
                }
            }
            
        }
        
        return ;
        
    }


    public int longest(int[] res){
        int max=0;
        
        int streak=0;
        for(int i:res){
            if(i==0){
                max=Math.max(max,streak);
                streak=0;
            }else{
                streak++;
            }

        }

        max=Math.max(max,streak);

        return max;
    }


    public int longestValidParentheses(String s) {
        int length=s.length();
        int[] res=new int[length];
        
        valid(s,res);

        return longest(res);   
    }
}