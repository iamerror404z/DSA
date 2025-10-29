class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String,String> map=new HashMap<>();

        for(List<String> temp:knowledge){
            map.put(temp.get(0),temp.get(1));
        }

        StringBuilder ans=new StringBuilder();

        int left=0, right=0,len=s.length();

        char[] chars=s.toCharArray();

        while(left<len){
            right=left;

            while(chars[left]=='(' && right<len &&chars[right]!=')'){
                right++;
            }

            if(left!=right){
                String key=s.substring(left+1,right);
                String value=map.getOrDefault(key,"?");
                ans.append(value);
                left=right;
            }


            if(chars[left]!='(' && chars[left]!=')'){
                ans.append(chars[left]);
            }

            left++;
        }



        return ans.toString();
        
    }
}