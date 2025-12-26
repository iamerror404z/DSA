class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        
        for(int i=s.length()-1;i>=0;i--){
            if(stack.size()>=1 && stack.peek()==map.get(s.charAt(i))){
                stack.pop();
            }else{
                stack.add(s.charAt(i));
            }
        }



        return stack.size()==0;

    }
}