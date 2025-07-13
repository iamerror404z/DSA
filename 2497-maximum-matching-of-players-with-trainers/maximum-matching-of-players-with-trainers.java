class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int count=0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        int pointer=0;
        int req=0;

        for(int i:players){
            req=i;
        while(pointer<trainers.length-1 && req>trainers[pointer]){
            pointer++;

        }
        if(trainers[pointer]>=req){
            count++;
        }
        pointer=pointer+1;
         if(pointer>=trainers.length){
             return count;
         }
    }



        return count;
        
    }
}