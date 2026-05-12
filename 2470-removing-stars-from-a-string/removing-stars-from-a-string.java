class Solution {
    public String removeStars(String s) {
        Deque<Character> queue=new LinkedList<>();
        queue.addLast(s.charAt(0));

        for(int i=1;i<s.length();i++){
            char curr=s.charAt(i);

            if(curr=='*'){
                queue.pollLast();
            }else{
                queue.addLast(curr);
            }

        }
    StringBuilder sb=new StringBuilder();

    while(!queue.isEmpty()){
        sb.append(queue.pollFirst());
    }




        return sb.toString();
        
    }
}