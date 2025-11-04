class Solution {
    boolean found=false;
    String fin="";
    public void answer(String s,String aim){
        if(s.indexOf(aim)!=-1){

            System.out.println(s.indexOf(aim));

            s=s.replaceFirst(aim,"");
            System.out.println(s);
            answer(s,aim);
        }
        if(!found){
            found=true;
            fin=s;
        }
        return;
    }
    public String removeOccurrences(String s, String part) {
        
        answer(s,part);
        return fin;   
    }
}