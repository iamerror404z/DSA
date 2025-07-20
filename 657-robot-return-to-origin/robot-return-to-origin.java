class Solution {
    public boolean judgeCircle(String moves) {
        int Left=0;
        int Up=0;
        int pos=0;
        for(int i=0;i<moves.length();i++){
            char ch=moves.charAt(i);
            if(ch=='U') Up++;
            else if(ch=='D') Up--;
            else if(ch=='L') Left++;
            else if(ch=='R') Left--;
            
        }

        return (Left==0)&&(Up==0);
    }
}