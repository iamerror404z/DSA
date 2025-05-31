class Solution {
    public boolean digitCount(String num) {
        int[] freq=new int[10];
        // HashMap<Character,Integer> freq=new HashMap<>();
        for(int i=0;i<num.length();i++){
            // System.out.println(num.charAt(i));
            int value=Integer.valueOf(""+num.charAt(i));
            System.out.println(value);
            freq[value]=freq[value]+1;
            
        }
        for(int i=0;i<num.length();i++){
            int check=Integer.valueOf(""+num.charAt(i));
            if(freq[i]!=check){
                return false;
            }
        }

        return true;
    }
}