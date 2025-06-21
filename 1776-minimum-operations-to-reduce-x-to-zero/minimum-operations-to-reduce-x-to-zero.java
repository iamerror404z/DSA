class Solution {
    public int minOperations(int[] nums, int x) {
        int size=nums.length;
        int[] left=new int[size];
        int[] right=new int[size];
        int max=Integer.MAX_VALUE;
        int min1=max,min2=max;
        int ans=max;
        int l_limit=0;
        int r_limit=size-1;
        left[0]=nums[0];
        right[size-1]=nums[size-1];

        if(left[0]==x ||right[size-1]==x){
            return 1;
        }
        
        for (int i=1;i<size;i++){
            left[i]=left[i-1]+nums[i];
            if(left[i]==x){
                min1=(i+1);
            }if(left[i]<x){
                l_limit++;
            }}

            for (int i=size-2;i>=0;i--){
                right[i]=right[i+1]+nums[i];
                if(right[i]==x){
                    min2= size-i;
                }
                
                if(right[i]<x){
                    r_limit--;
                }
            }
            if(min1!=max || min2!=max){
            ans=Math.min(min1,min2);
            }

            if(right[0]<x || left[size-1]<x){
                return -1;
            }
            HashMap<Integer,Integer> track=new HashMap<>();  

            for (int i=r_limit;i<size;i++){
                track.put(right[i],i);
            }


            
            for (int i=0;i<=l_limit;i++){
                int req=x-left[i];
                int loc=track.getOrDefault(req,0);
                
                if(loc!=0){
                    ans=Math.min(ans ,(i+1)+(size-loc));
                }

            }
        if(ans==max){
            return -1;
        }

        return ans;
    }
}