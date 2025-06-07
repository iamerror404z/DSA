class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> freq=new HashMap<>();
        for(String s:s1.split(" ")){
            if(freq.containsKey(s)){
                freq.put(s,freq.get(s)+1);
            }else{
                freq.put(s,1);
            }
        }
        for(String s:s2.split(" ")){
            if(freq.containsKey(s)){
                freq.put(s,freq.get(s)+1);
            }else{
                freq.put(s,1);
            }
        }
        ArrayList<String> step=new ArrayList<>();
        for(String s:freq.keySet()){
            if(freq.get(s)<2){
                step.add(s);
            }
        }
        String[] ans=new String[step.size()];
        int point=0;

        for(String s:step){
            ans[point++]=s;
        }

        return ans;

        }
    }