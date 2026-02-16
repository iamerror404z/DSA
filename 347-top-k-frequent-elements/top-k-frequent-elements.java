class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count=new HashMap<>();
        for(int i:nums){
            count.put(i,count.getOrDefault(i,0)+1);
        }


        Map<Integer,Queue<Integer>> map=new TreeMap<>(Collections.reverseOrder());
        int min=Integer.MAX_VALUE;
        int max=0;

        
        List<Integer> keys=new LinkedList<Integer>();
        for(int i:count.keySet()){
            int num=i;
            int times=count.get(num);
           
            if(map.containsKey(times)){
                map.get(times).add(num);
            }else{
                Queue<Integer> queue=new LinkedList<>();
                queue.add(num);
                map.put(times,queue);
            }



        }

        int index=0;
        int[] ans=new int[k];

        for(int i:map.keySet()){
            int size=map.get(i).size();

            while(index<k && map.get(i).size()>0){
                ans[index++]=map.get(i).poll();
            }
            if(index>=k){
                return ans;
            }
        }



        return ans;
    }
}