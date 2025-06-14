class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> lst=new ArrayList<>();

        for (int i=0;i<n;i++){
            int num=i+1;
            if(num%3==0 && num%5==0){
                lst.add("FizzBuzz");
            }else if(num%3==0){
                lst.add("Fizz");
            }else if(num%5==0){
                lst.add("Buzz");
            }else{
                lst.add(""+num);
            }
        }
        
        return lst;
    }
}