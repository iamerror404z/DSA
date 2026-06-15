class Solution {
    public int findMinDifference(List<String> timePoints) {
        int size=timePoints.size();
        int[] times=new int[size];

        for(int i=0;i<size;i++){
            String t=timePoints.get(i);
            int hours=Integer.parseInt(t.substring(0,2));
            int minutes=Integer.parseInt(t.substring(3,5));

            int time=(hours*60)+minutes;

            times[i]=time;
        }


        int endDay=(24*60);


        Arrays.sort(times);

        
        int min=endDay-times[size-1]+times[0];

        // System.out.println(Arrays.toString(times));


        for(int i=1;i<size;i++){
            int currMin=times[i]-times[i-1];
            min=Math.min(min,currMin);
        }




        return min;
    }
}