class Solution {
    public String largestPalindromic(String num) {
        int[] map=new int[10];
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<num.length();i++){
            char curr=num.charAt(i);
            map[curr-'0']++;
        }

        int max=0;



        for(int i=9;i>=1;i--){
            for(int j=1;j<=(map[i]/2);j++){
                sb.append(i);
            }
            if(map[i]%2!=0){
                max=Math.max(max,i);
            }


        }

        if(sb.length()>0){
            for(int i=1;i<=map[0]/2;i++){
                sb.append(0);
            }
        }

        

        int size=sb.length();

       

        if(map[max]%2==1 || (max==0 && size==0)){
            sb.append(max);
        }

        for(int i=size-1;i>=0;i--){
            sb.append(sb.charAt(i));
        }




        return sb.toString();
    }
}