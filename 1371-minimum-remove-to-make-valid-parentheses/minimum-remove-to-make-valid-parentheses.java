class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb=new StringBuilder();
        Deque<Integer> deque=new LinkedList();


        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);


            if(curr=='('){
                deque.addLast(i);
            }else if(curr==')'){
                if(!deque.isEmpty() && s.charAt(deque.peekLast())=='('){
                deque.pollLast();
                }else{
                    deque.addLast(i);
                }
            
         }

        }


         for(int i=0;i<s.length();i++){
            if(!deque.isEmpty() && i==deque.peekFirst()){
                deque.pollFirst();
                continue;
            }

            sb.append(s.charAt(i));
         }


        

        return sb.toString();
    }
}