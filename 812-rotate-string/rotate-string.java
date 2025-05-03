class Solution {
    public boolean rotateString(String s, String goal) {
        for(int i=0;i<s.length();i++){
            String b=s.substring(i)+s.substring(0,i);
            // +s.substring(i);
            System.out.println(b);
            if(b.equals(goal)){
                return true;
            }
        }return false;
    }
}