class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int pos=0;
        for(String i:sentence.split(" ")){
            if(i.startsWith(searchWord)){
                return pos+1;
            }else{
                pos++;
            }

        }


        return -1;
    }
}