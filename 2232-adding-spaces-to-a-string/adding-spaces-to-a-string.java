class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb=new StringBuilder();
        int pointer=0;

        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);

            if(pointer<spaces.length && i==spaces[pointer]){
                sb.append(" ");
                sb.append(curr);
                pointer++;
            }else{
                sb.append(curr);
            }

        }


        return sb.toString();
    }
}