class Solution {
    public boolean checkString(String s) {
        int loc=s.indexOf("b");
        if(loc==-1){
            return true;
        }
        for(int i=loc;i<s.length();i++){
            if(s.charAt(i)=='a'){
                return false;
            }
        }

        return true;
    }
}