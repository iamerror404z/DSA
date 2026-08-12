class Solution {

    public int updateStart(int start,int curr,List<Integer> times){
        int pos=0;

        int time2=times.get(curr);

        int h2=time2/100;
        int min2=time2%100;

        for(int i=start;i<=curr;i++){
            int time1=times.get(i);

            int h1=time1/100;
            int min1=time1%100;

            int diff=(h2*60)+(min2)-((h1*60)+min1);

            if(diff<60){
                pos=i;
                break;
            }

            

        }

        return pos;
    }

    public boolean isHigh(List<Integer> times){
        int prevTime=times.get(0);
        int size=times.size();

        int start=0;

        for(int i=1;i<size;i++){
            int currTime=times.get(i);

            start=updateStart(start,i,times);
            int windowSize=i-start+1;

            if(windowSize>=3){
                return true;
            }

        }




        return false;
    }


    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String,List<Integer>> map=new HashMap<>();

        for(List<String>  curr:access_times){
            String currId=curr.get(0);
            String currTime=curr.get(1);
            List<Integer> times=map.getOrDefault(currId,new LinkedList<>());

            if(times.size()==0){
                map.put(currId,times);
            }

            times.add(Integer.parseInt(currTime));
        }
        
        
        List<String> res=new LinkedList<>();


        for(String id:map.keySet()){
            List<Integer> times=map.get(id);
            Collections.sort(times);

            boolean isHigh=isHigh(times);

            if(isHigh){
                res.add(id);
            }
        }
        

        return res;
    }
}