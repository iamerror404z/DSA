class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] alpha=new int[26];
        for(int i=0;i<sentence.length();i++){
            alpha[sentence.charAt(i)-'a']=1;
        }
        int sum=0;

        for(int i:alpha){
            sum+=i;
        }

        return sum>=26;
        
    }
}