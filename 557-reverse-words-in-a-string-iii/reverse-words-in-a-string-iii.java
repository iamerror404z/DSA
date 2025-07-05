class Solution {
    public String reverseWords(String s) {
        List<String> lst=new ArrayList<>(Arrays.asList(s.split(" ")));
        StringBuilder ans=new StringBuilder();
        int point=0;
        int len=0;

        for(String word:lst){
            word=word.trim();
            len=word.length();
            point=len-1;

            while(point!=-1){
                ans.append(word.charAt(point));
                point--;
            }
            ans.append(" ");
        }


        return ans.toString().trim();
        
    }
}