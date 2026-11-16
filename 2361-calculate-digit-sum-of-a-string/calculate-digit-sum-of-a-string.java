class Solution {

    public void revAndPush(int num,Queue<Integer> next){
        if(num==0){
            return ;
        }

        revAndPush(num/10,next);
        next.offer(num%10);

    }


    public void process(int k,Queue<Integer> curr,Queue<Integer> next){

        int size=Math.min(k,curr.size());

        // 0 based indexing converstion 
        int m=size-1;

        int sum=0;

        while(m>=0){
            sum+=curr.poll();

            m--;
        }

        // reverse part 

        revAndPush(sum,next);

        if(sum==0){
            next.offer(0);
        }



    }


    public String digitSum(String s, int k) {
        Queue<Integer> curr=new LinkedList<>();

        // Load the data

        for(int i=0;i<s.length();i++){
            int d=s.charAt(i)-'0';

            curr.offer(d);

        }

        // Process it

        while(curr.size()>k){
            Queue<Integer> next=new LinkedList<>();

            while(!curr.isEmpty()){
                process(k,curr,next);

            }


            curr=next;
        }   


        // build the string 
        StringBuilder res=new StringBuilder();

        while(!curr.isEmpty()){
            res.append(curr.poll());
        }

        



        return res.toString();
    }
}