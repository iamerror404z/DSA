
class Solution {
    public String smallestPalindrome(String s) {
        int length=s.length();
        int[] freq=new int[26];
        char[] chars=s.toCharArray();

        for(char ch:chars){
            freq[ch-'a']++;
        }

        int start=0;
        int end=length-1;
        
        int mid=-1;

        System.out.println(Arrays.toString(freq));


        for(int i=0;i<26;i++){
            char curr=(char)('a'+i);

            int times=freq[i];


            while(times>=2){
                chars[start]=curr;
                chars[end]=curr;
                start++;
                end--;
                times-=2;

            }
            
            if(times!=0){
                mid =i;
            }

        }
        
        if(mid!=-1){
            char curr=(char)('a'+mid);
            
            chars[length/2]=curr;
        }
        
        
        

        return new String(chars);
    }
}