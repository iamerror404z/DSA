class Solution {
    public int maxDistance(String s, int k) {
        int[] dir=new int[4];
        int max=0;
        // north =0, south=1,west=2,east=3;

        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(curr=='N'){
                dir[0]++;
            }else if(curr=='S'){
                dir[1]++;
            }else if(curr=='W'){
                dir[2]++;
            }else{
                dir[3]++;
            }

            int verticalNeeded=Math.min(dir[0],dir[1]);
            int horizontalNeeded=Math.min(dir[2],dir[3]);
            int totalNeeded=verticalNeeded+horizontalNeeded;

            int currSum=Math.max(dir[0],dir[1])+Math.max(dir[2],dir[3]);
            int adjustMent=0;

            if(totalNeeded<=k){
                adjustMent=totalNeeded;
            }else{
                adjustMent=k-(totalNeeded-k);
            }


            
            currSum+=+adjustMent;

            max=Math.max(max,currSum);
            



        }

        

        


        return max;
    }
}