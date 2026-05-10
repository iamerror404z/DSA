class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int level=1;
        int size=1;
        int[] curr=new int[3];
        int[] prev=new int[3];

        curr[0]=1;
        curr[1]=1;
        curr[2]=1;

        while(curr[1]<label){
            for(int i=0;i<3;i++){
                prev[i]=curr[i];
            }
            curr[2]++;
            curr[0]=curr[1]+1;
            curr[1]=(curr[1]*2)+1;
        }

        int parent=label;
        List<Integer> res=new LinkedList<>();

        while(curr[1]>0){
            res.add(parent);
            

            int newParent=prev[0];

            int distance=curr[2]%2==0?(curr[1]-parent)/2:(parent-curr[0])/2;

            if(curr[2]%2==0){
                newParent=prev[0]+distance;
            }else{
                newParent=prev[1]-distance;
            }


            for(int i=0;i<3;i++){
                curr[i]=prev[i];
            }

            prev[2]--;
            prev[1]=curr[0]-1;
            prev[0]=curr[0]/2;
            parent=newParent;

        }

        size=res.size();

        for(int i=0;i<size/2;i++){
            int temp=res.get(size-(i+1));
            res.set(size-(i+1),res.get(i));
            res.set(i,temp);
        }


        return res;
    }
}