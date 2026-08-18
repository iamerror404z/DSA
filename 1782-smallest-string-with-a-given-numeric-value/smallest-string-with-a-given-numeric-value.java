class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb=new StringBuilder();


        int remK=k;
        for(int i=1;i<=n;i++){
            int cap=(n-i)*26;
            int ch=remK-cap;
            ch=Math.max(ch,1);

            sb.append((char)(96+ch));
            remK-=ch;
        }

        // System.out.println(sb.toString());

        return sb.toString();
    }
}