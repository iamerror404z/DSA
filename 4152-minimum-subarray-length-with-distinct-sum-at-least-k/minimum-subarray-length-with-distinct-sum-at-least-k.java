class Solution {
    
    public int[] updatedStart(int start,int end,int sum,int k
    ,Map<Integer,Integer> map,int[] nums){
       
        int pos=start;
        int[] res=new int[2];


        // System.out.println("range is : "+start+" -- > "+end);
        // System.out.println("sum vs k : "+sum+" vs  "+k);
        
        for(int i=start;i<=end;i++){
            int curr=nums[i];
            
            if(map.get(curr)==i){
                
                if(curr==1){
                    // System.out.println("sum-- is : "+(sum-curr));
                }

                if(sum-curr>=k){
                    sum-=curr;
                }else{
                    
                    pos=i;
                    break;
                }
                
            }
        }
        
        res[0]=pos;
        res[1]=sum;
        
        
        return res;    
    }
    
    
    public int minLength(int[] nums, int k) {
       
        int subArrSize=Integer.MAX_VALUE;
        Map<Integer,Integer> map=new HashMap<>();
        int length=nums.length;
        
        int sum=0;
        int start=0;

        for(int i=0;i<length;i++){
            int curr=i==length?0:nums[i];

            
            if(!map.containsKey(curr) || map.get(curr)<start){
                sum+=curr;
                
            }
             map.put(curr,i);
            
        
            
            if(sum>=k){
                int[] updatedVal=updatedStart(start,i,sum,k,map,nums);

                int newStart=updatedVal[0];
                int end=i+1;
                int windowSize=end-newStart;
                sum=updatedVal[1];


                start=newStart;
                subArrSize=Math.min(subArrSize,windowSize);


                // System.out.println("index is : "+i);
                // System.out.println(Arrays.toString(updatedVal));

                // System.out.println("windowSize is : "+windowSize);
                // System.out.println("Sum is : "+sum);

                // System.out.println(windowSize);
                }   

                
            }
            


        if(subArrSize==Integer.MAX_VALUE){
            return -1;
        }





        return subArrSize;
        
    }
}