class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] requirments=new int[26];
        requirments[1]=1;
        requirments[0]=1;
        requirments[11]=2;
        requirments[14]=2;
        requirments[13]=1;

        String key="balon";

        int[]  freq=new int[26];

        for(char ch:text.toCharArray()){
            freq[ch-'a']++;
        }

        int min=Integer.MAX_VALUE;

        for(char ch:key.toCharArray()){
            int currIndex=ch-'a';
            int curr=freq[currIndex]/requirments[currIndex];
            min=Math.min(min,curr);
        }



        return min;
        
    }
}