
class Solution {
    public long[] getDistances(int[] arr) {
        Map<Integer,long[]> map=new HashMap<>();
        int length=arr.length;
        
        for(int i=0;i<length;i++){
            int curr=arr[i];
            
            long[] currVal=map.getOrDefault(curr,new long[4]);
            
            currVal[2]+=i;
            currVal[3]++;
            
            if(currVal[3]==1){
                map.put(curr,currVal);
            }
            
        }
        
        long[] res=new long[length];
        
        
        for(int i=0;i<length;i++){
            int curr=arr[i];
            
            long[] currVal=map.get(curr);
            
            currVal[2]-=i;
            currVal[3]--;
            
            long leftSum=0;
            long rightSum=0;
            
            if(currVal[3]>0){
                leftSum=currVal[2]-(currVal[3]*i);
            }
            if(currVal[1]>0){
                rightSum=(i*currVal[1])-currVal[0];
            }
            
            res[i]=leftSum+rightSum;
            
            currVal[0]+=i;
            currVal[1]++;
        }
        
        
        
        return res;
    }
}