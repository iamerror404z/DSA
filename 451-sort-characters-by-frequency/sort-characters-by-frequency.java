class Solution {
    public String frequencySort(String s) {
        StringBuilder ans=new StringBuilder("");

        HashMap<Character,Integer> track=new HashMap<>();

        for(char curr:s.toCharArray()){
            int count=track.getOrDefault(curr,0);
            track.put(curr,count+1);}

        
        HashMap<Integer,List<Character>> sort=new HashMap<>();
        List<Integer> keys=new ArrayList<>();

        for(char ch:track.keySet()){
            int count=track.get(ch);
            if(sort.keySet().contains(count)){
                sort.get(count).add(ch);
            }else{
                List<Character> lst=new ArrayList<Character>();
                lst.add(ch);
                sort.put(count,lst);
                keys.add(count);
            }
        }

                Collections.sort(keys);

                for(int i=keys.size()-1;i>=0;i--){
                    for(char ch:sort.get(keys.get(i))){
                        for(int j=0;j<keys.get(i);j++){
                            ans.append(ch);
                        }
                    }
                }
            
        
        return ans.toString();
        
    }
}