class Solution {
    public int minimizeSum(int[] nums) {
       int[] max=new int[3];

       int[] min=new int[3];
       Arrays.fill(min,Integer.MAX_VALUE);

       for(int curr:nums){
        if(curr>max[2]){
            
            
            max[0]=max[1];
            max[1]=max[2];

            
            max[2]=curr;
        }else if(curr>max[1]){

            max[0]=max[1];

            max[1]=curr;
        }else if(curr>max[0]){
            max[0]=curr;
        }


        if(curr<min[0]){

            min[2]=min[1];
            min[1]=min[0];
            min[0]=curr;
        }else if(curr<min[1]){
            min[2]=min[1];
            min[1]=curr;
        }else if(curr<min[2]){
            min[2]=curr;
        }

       }





        System.out.println(Arrays.toString(max));    
        System.out.println(Arrays.toString(min));

        // please note that min absolute will become somehow zero and it doesnt contribute 
        int res=Integer.MAX_VALUE;
        for(int i=0;i<3;i++){
            int allowed=3-i;

            for(int j=0;j<allowed;j++){
                int curr=max[2-j]-min[i];

                res=Math.min(res,curr);
            }

        }


        return res;
    }
}