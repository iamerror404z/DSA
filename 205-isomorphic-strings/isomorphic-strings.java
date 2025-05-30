class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        HashMap<Character,Character> track1=new HashMap<>();
        HashMap<Character,Character> track2=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char point=s.charAt(i);
            char value=t.charAt(i);
            char map=track1.getOrDefault(point,value);
            char rev=track2.getOrDefault(value,point);
            System.out.println(point+" vs "+value);
            // System.out.println(i+": num "+value+" vs "+map);
            // System.out.println(track.get(value)+" vs "+point+"\n");
            // boolean move=(track.get(value)!=point);
            // System.out.println(point+" snd"+value+"  "+move);
            System.out.println();
            System.out.println(rev!=point);
            if(map!=value || rev!=point){
                return false;
            }
            if(track1.get(point)==null){
                track1.put(point,value);
            }if(track2.get(value)==null){
            // track.put(point,value);
            track2.put(value,point);
        }
        }
        // return false;
        return true;
    }
}