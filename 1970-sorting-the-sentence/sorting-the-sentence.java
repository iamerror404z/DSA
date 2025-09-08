class Solution {
    public String sortSentence(String s) {
        Map<Integer,String> mapping=new HashMap<>();
        int size=1;
        for(String i:s.split(" ")){
            int len=i.length();
            int loc=i.charAt(len-1)-'0';
            mapping.put(loc,i.substring(0,len-1));
            size++;
        }
        StringBuilder ans=new StringBuilder();

        for(int i=1;i<size;i++){
            ans.append(mapping.get(i)).append(" ");
        }


        return ans.toString().trim();
    }
}