class Solution {
    public int firstUniqChar(String s) {
       HashMap<Character,Integer> track=new HashMap<>();
       for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int count=track.getOrDefault(ch,0);
            track.put(ch,count+1);

        }
        
        for(int i=0;i<s.length();i++){
            if(track.get(s.charAt(i))==1){
                return i;
            }
        }
        
        return -1;
    }
}