class Solution {
    public boolean areOccurrencesEqual(String s) {
        Map<Character,Integer> count=new HashMap<>();
        char key='a';
        for(char ch:s.toCharArray()){
            key=ch;
            int loop=count.getOrDefault(ch,0);
            count.put(ch,loop+1);
        }

        int loop=count.get(key);
        for(char ch:count.keySet()){
            if(count.get(ch)!=loop){
                return false;
            }
        }


    return true;
    }
}