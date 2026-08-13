class Solution {

    public boolean isPossible(int[] dist,double hour,int speed){
        double required=0;


        for(int i=0;i<dist.length;i++){
            required=Math.ceil(required);
            int curr=dist[i];

            double currRequired=curr/(double)speed;
            required+=currRequired;

            
            if(required>hour){
                return false;
            }
        }




        return true;
    }


    public int minSpeedOnTime(int[] dist, double hour) {
        int speed=-1;
        int start=1;
        int end=(int)Math.pow(10,7);

        // binary search
        while(start<=end){
            int mid=start+(end-start)/2;

            if(isPossible(dist,hour,mid)){
                speed=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }

        
        return speed;
    }
}