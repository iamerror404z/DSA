class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> freq=new HashMap<>();
        HashSet<Character> vow=new HashSet<>();
        HashSet<Character> cons=new HashSet<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int count=freq.getOrDefault(ch,0);
            freq.put(ch,count+1);
            if(ch=='a' || ch=='e' ||ch=='i' || ch=='o' ||ch=='u'){
                vow.add(ch);
            }else{
                cons.add(ch);
            }}

            int max1=-0,max2=0;
            for(char ch:vow){
                if(freq.get(ch)>max1){
                    max1=freq.get(ch);
                }}
            for(char ch:cons){
                if(freq.get(ch)>max2){
                    max2=freq.get(ch);}}
               
            return max1+max2;

    }
}