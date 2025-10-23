class Solution {
    Map<Integer,List<Integer>> track=new HashMap<>(); 

    public int[][] kClosest(int[][] points, int k) {
        int[][] ans=new int[k][2];
        List<Integer> keys=new LinkedList<>();

        int required=k;

        for(int i=0;i<points.length;i++){
            int[] temp=points[i];
            int distance=(temp[0]*temp[0])+(temp[1]*temp[1]);

            if(track.containsKey(distance)){
                track.get(distance).add(i);
            }else{
                keys.add(distance);
                List<Integer> lister=new LinkedList<>();
                lister.add(i);
                track.put(distance,lister);

            }
        }

        Collections.sort(keys);
        int pointer=0;

        for(int i:keys){
            int size=track.get(i).size();
            size=Math.min(size,required);
            List<Integer> temp=track.get(i);

            for(int j=0;j<size;j++){
                ans[pointer++]=points[temp.get(j)];
            }

            
            required-=size;
            if(required<=0){
                break;
            }
        }





        return ans;
    }
}