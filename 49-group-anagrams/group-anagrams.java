class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<ArrayList<Integer>,ArrayList<String>> group =new HashMap<>();

        for(String s:strs){


            ArrayList<Integer> key=new ArrayList<>(Collections.nCopies(26,0));
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                key.set(ch-'a',key.get(ch-'a')+1);


            }
            if(group.containsKey(key)){
            group.get(key).add(s);}
            else{
                ArrayList<String> gg=new ArrayList<>();
                gg.add(s);
                group.put(key,gg);
            }
        }

        

            List<List<String>> ans=new ArrayList<>();
            for(ArrayList<Integer> ls:group.keySet()){
                ans.add(group.get(ls));
            }

            return ans;


        }
}