class Solution {
    public List<String> stringMatching(String[] words) {
        StringBuilder bh=new StringBuilder();
        List<String> lst=new ArrayList<>();
        for(String i:words){
            bh.append(i+",");
        }
        String check=bh.toString();

        for(String i:words){
            if(check.indexOf(i)!=check.lastIndexOf(i)){
                lst.add(i);
            }
        }

        return lst;

    }
}