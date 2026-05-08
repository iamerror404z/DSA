class Solution {

    public int[] helper(int number,Map<Integer,Character> map,int curr,int prev,int type,StringBuilder sb){
        int[] res=new int[2];

        res[1]=(type==1?curr/2:curr/5);
        
        if(number==0 || number<curr){
            res[0]=number;
            return res;
        }

    
        int limit=1;

        if(type==1){
            limit=3;}
        

        int currTimes=number/curr;

        if(type==1 && currTimes>limit){
            sb.append(map.get(curr));
            sb.append(map.get(prev));
            res[0]=number%curr;

            return res;
        }
        


        int numberLimit=(2*curr)-(curr/5);


        if(type==0 && (number>=numberLimit)){
           res[0]=number-numberLimit;

           sb.append(map.get(res[1]));
           sb.append(map.get(prev));

           return res;
        }


    


        

        for(int i=0;i<currTimes;i++){
            sb.append(map.get(curr));
        }

        res[0]=number%curr;


        
        return res;

    }


    public String intToRoman(int num) {
        StringBuilder sb=new StringBuilder();
        Map<Integer,Character> map=new HashMap<>();

        map.put(1,'I');
        map.put(5,'V');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(1000,'M');

        

        int prev=5000;
        int curr=1000;
        int type=1;
        int number=num;


        while(number!=0){
            int [] res=helper(number,map,curr,prev,type,sb);
            number=res[0];
            prev=curr;
            type=(type==0?1:0);
            curr=res[1];
        }


        return sb.toString();
    }
}