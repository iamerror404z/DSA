class Solution {

    public void recursion(String s,int index,Map<Character,String> map,List<String> ans,String given){
        if(index>=given.length()){
            ans.add(s);
            return;
        }
        
        String variable=map.get(given.charAt(index));
        
        for(int i=0;i<variable.length();i++){
            recursion(s+variable.charAt(i),index+1,map,ans,given);
        }

        

    }

    public List<String> letterCombinations(String digits) {
    Map<Character,String> map=new HashMap<>();
    
    map.put('2',"abc");
    map.put('3',"def");
    map.put('4',"ghi");
    map.put('5',"jkl");
    map.put('6',"mno");
    map.put('7',"pqrs");
    map.put('8',"tuv");
    map.put('9',"wxyz");

    List<String> ans=new LinkedList<>();
    String given=digits;
    int index=0;

    recursion("",index,map,ans,given);
     
    return ans;   
    }
}