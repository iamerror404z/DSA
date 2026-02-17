class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        
        Map<Character,Integer> map=new HashMap<>();
        int start=0;

        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);

            if(map.containsKey(curr) && map.get(curr)>=start){
                start=map.get(curr)+1;

            }
            map.put(curr,i);
            System.out.println(i-start+1);
            max=Math.max(max,i-start+1);
        }
        


        return max;
    }
}