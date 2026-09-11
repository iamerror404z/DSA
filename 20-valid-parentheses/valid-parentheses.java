class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        for(char ch:s.toCharArray()){

            if(map.containsKey(ch)){

                if(!stack.isEmpty() && map.get(ch)==stack.peek()){
                    stack.pop();
                }else{
                    stack.push(ch);
                }

            }else{
                stack.push(ch);
            }


        }




        return stack.isEmpty();
    }
}