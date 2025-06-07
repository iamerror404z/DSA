class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time=0;
        int[] freq=new int[tickets.length];

        while(freq[k]!=tickets[k]){
            for(int i=0;i<tickets.length;i++){
                if(tickets[i]!=freq[i]){
                    freq[i]++;
                    time++;
                }
                if(i==k &&freq[k]==tickets[k]){
                    return time;
                }
            }
        }
        

        return -1;
    }
}