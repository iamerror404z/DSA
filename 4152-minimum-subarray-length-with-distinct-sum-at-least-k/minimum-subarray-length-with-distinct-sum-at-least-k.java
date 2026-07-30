/*
code review;
    improve the code quality and think about
    think about the egde casee

    a good code s not something that works by luck 

    it should have been proved theoratically before implementaion




*/



class Solution {
    
    public int[] updatedStart(int start,int end,int sum,int k
    ,Map<Integer,Integer> map,int[] nums){
        int pos=0;
        int[] res=new int[2];
        
        for(int i=start;i<=end;i++){
            int curr=nums[i];
            
            if(map.getOrDefault(curr,i)==i){
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
            
            if(sum>=k){
                int[] updatedVal=updatedStart(start,i,sum,k,map,nums);

                int newSum=updatedVal[1];
                int newStart=updatedVal[0];
                int end=i+1;
                int windowSize=end-newStart;

                sum=newSum;
                start=newStart;
                
                subArrSize=Math.min(subArrSize,windowSize);

                
            }
            

            map.put(curr,i);
        }

        if(subArrSize==Integer.MAX_VALUE){
            return -1;
        }





        return subArrSize;
        
    }
}