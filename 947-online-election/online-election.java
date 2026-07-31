class TopVotedCandidate {
    final private int[] leading;
    final private int[] times;


    public TopVotedCandidate(int[] persons, int[] times) {
        this.times=times;
        int length=persons.length;
        leading=new int[length];
        int lead[]=new int[2];
        Map<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<length;i++){
            int candidate=persons[i];

            int candidateVotes=map.getOrDefault(candidate,0)+1;

            if(candidateVotes>=lead[1]){
                lead[1]=candidateVotes;
                lead[0]=candidate;
            }

           leading[i]=lead[0];

            map.put(candidate,candidateVotes);
        }
        



        
        return ;
    }

    public int binarySearch(int t){
        int length=leading.length;

        int start=0;
        int end=length-1;

        int candidate=0;


        while(start<=end){
            int mid=start+(end-start)/2;

            if(times[mid]>t){
                end=mid-1;
            }else{
                candidate=leading[mid];
                start=mid+1;
            }


        }

        return candidate;

    }
    
    public int q(int t) {

        int candidate=binarySearch(t);


        return candidate;   
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */