class Solution {
    public String smallestPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        
        int[] map=new int[26];
        
        for(char ch:s.toCharArray()){
            int currIndex=ch-'a';
            map[currIndex]++;
        };
        
        int middle=-1;
        
        for(int i=0;i<26;i++){
            int repeatedTimes=map[i];
            
            if(repeatedTimes%2!=0){
                middle=i;
                map[i]--;
            }
            
            char curr=(char)('a'+i);
            for(int j=0;j<repeatedTimes/2;j++){
                sb.append(curr);
            }
            map[i]/=2;
            
            
        }



        
        if(middle!=-1){
            char mid=(char)('a'+middle);
            sb.append(mid);
        }

        
        
        System.out.println(Arrays.toString(map));
        
        
        for(int i=25;i>=0;i--){
            int repeatedTimes=map[i];
            
            
           
            
            char curr=(char)('a'+i);

            for(int j=0;j<repeatedTimes;j++){
                sb.append(curr);
            }
            
        }
        
        return  sb.toString();
        
    }
}