class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> available=new TreeSet<>();
        PriorityQueue<int[]> used=new PriorityQueue<>(new MyComp());
        int requestDropped=0;


        int[] requests=new int[k];
        for(int i=0;i<k;i++){
            available.add(i);
        }


        int max=0;
        int bound=(int)Math.pow(10,9)+2;
        for(int i=0;i<arrival.length;i++){
            int currTime=arrival[i];
            int endTime=currTime+load[i];


        while(!used.isEmpty() && used.peek()[1]<=currTime){

            available.add(used.poll()[0]);
        }


        if(available.isEmpty()){
            requestDropped++;
            continue;
        }

        Integer server=available.ceiling(i%k)!=null?available.ceiling(i%k):available.first();


        used.add(new int[]{server,endTime});
        requests[server]++;
        max=Math.max(max,requests[server]);
        available.remove(server);

        }


        


        


        List<Integer> out = new LinkedList<>();

        for(int i=0;i<k;i++){
            if(requests[i]==max){
                out.add(i);
            }

        }

        return out;
    }
}



class MyComp implements Comparator<int[]>{

    @Override
    public int compare(int[] a,int[] b){

        if(a[1]!=b[1]){
            return a[1]-b[1];
        }

        return a[0]-b[0];
    }


} 