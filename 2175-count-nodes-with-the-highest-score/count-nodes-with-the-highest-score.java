class Solution {
    public int maxScore(int curr,int[][] tree,int size,long[] max){
        if(curr==-1){
            return 0;
        }

        int left=maxScore(tree[curr][0],tree,size,max);
        int right=maxScore(tree[curr][1],tree,size,max);


        int up=Math.max(1,size-(left+right+1));

        long product=1L*Math.max(1,up)*Math.max(1,left)*Math.max(1,right);




        max[curr]=product;
        max[size]=Math.max(max[size],product);







        return left+1+right;
    }


    public int countHighestScoreNodes(int[] parents) {
        int size=parents.length;
        int[][] tree=new int[size][2];

        for(int i[]:tree){
            Arrays.fill(i,-1);
        }

        long max[]=new long[size+1];

        
        for(int i=1;i<size;i++){
            int curr=i;
            int parent=parents[i];

            if(tree[parent][0]==-1){
                tree[parent][0]=curr;
            }else{
                tree[parent][1]=curr;
            }
        }



        maxScore(0,tree,size,max);
        int count=0;


        for(long i:max){
            if(i==max[size]){
                count++;
            }
        }

        


        return count-1;
    }
}