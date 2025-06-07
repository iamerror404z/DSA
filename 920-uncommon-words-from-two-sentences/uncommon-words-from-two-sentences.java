class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> track=new HashMap<>();
        List<String> lst1=new ArrayList<>(Arrays.asList(s1.split(" ")));
        List<String> lst2=new ArrayList<>(Arrays.asList(s2.split(" ")));

        for(String s:lst1){
            int freq=track.getOrDefault(s,0);
            track.put(s,freq+1);
        }
        for(String s:lst2){
            int freq=track.getOrDefault(s,0);
            track.put(s,freq+1);
        }
        
        List<String> ans=new ArrayList<>();
        
        for (String key:track.keySet()){
            if(track.get(key)<2){
                ans.add(key);
            }
        }
        String[] fin=ans.toArray(new String[0]);

        return fin;

    }
}