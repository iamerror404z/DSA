class Solution {
    public int minimumPushes(String word) {
        int res=0;
        int length=word.length();

        System.out.println("length is : "+length);

        int ones=Math.min(length,8);

        int twoes=Math.min(length-8,8);
        twoes=Math.max(0,twoes);
        
        int threes=Math.min(8,length-16);
        threes=Math.max(threes,0);

        int foures=Math.max(0,length-24);
        
        

        return ones+(twoes*2)+(threes*3)+(foures*4);
    }   
}