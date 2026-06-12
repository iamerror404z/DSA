class Solution {
    public long minRightPart(int digit,Stack<Integer> stack){
        int size=stack.size();
        int mul=size+1;
        long numBuild=(long)Math.pow(10,mul);
        long numBuildSub=numBuild;

        long rightShift=1;
      

       int found=0;

       

        for(int i=0;i<=size;i++){
            int curr=stack.pop();
            int next=!stack.isEmpty()?stack.peek():0;

            if(curr>digit && found==0 && next<=digit){
                found=1;
                long maxD=curr*(long)Math.pow(10,mul-1);
                numBuild+=maxD;
                stack.push(digit);
                
            }else{
                long currD=curr*rightShift;
                numBuild+=currD;

                rightShift*=10;
            }





        }



        long res=numBuild-numBuildSub;


       





        return res;
    }



    public int nextGreaterElement(int n) {
        Stack<Integer> stack=new Stack();
        

        stack.add(n%10);

        int b=n/10;


        while(b!=0){
            int currDigit=b%10;
            b/=10;
            if(currDigit<stack.peek()){
                long left=(long)b;
                left*=(long)Math.pow(10,stack.size()+1);
                long right=minRightPart( currDigit,stack);

                if(left+right>Integer.MAX_VALUE){
                    return -1;
                }

                
                
                return (int)(left+right);

            }

        

            stack.add(currDigit);
        }


        




        return -1;
    }
}