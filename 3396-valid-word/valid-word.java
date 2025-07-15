class Solution {
    public boolean isValid(String word) {
        int total=0;
        int vowels=0,constent=0,others=0,nums=0;
        word=word.toLowerCase();

        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(ch=='a' || ch=='e' ||ch=='i'||ch=='o'||ch=='u'){
                vowels++;
            }else if(ch>='a' && ch<='z'){
                constent++;
            }else if(ch>='0' &&ch<='9'){
                nums++;
            }else{
                others++;
            }
        }

        total=vowels+constent+nums;
        if(others>0 || vowels<1 || constent<1 || total<3){
            
            return false;
        }

        return true;
        
    }
}