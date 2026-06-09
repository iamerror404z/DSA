class Solution {

    public boolean hasCycle(int curr,int[] left,int[] right,int[] isVisited){
        if(curr==-1){
            return false;
        }

        isVisited[curr]++;
        isVisited[left.length]++;

        if(isVisited[curr]>1){
            return true;
        }

        boolean leftRes=hasCycle(left[curr],left,right,isVisited);
        boolean rightRes=hasCycle(right[curr],left,right,isVisited);


        if(curr==2){
            System.out.println(Arrays.toString(isVisited));
        }


        return leftRes || rightRes;


    }


    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int size=n;
        int[] seen=new int[size+1];



        for(int i=0;i<n;i++){
            int parent=i;
            int kid1=leftChild[i];
            int kid2=rightChild[i];
            

            if(kid1!=-1){
                seen[kid1]++;
                seen[size]++;
            }

            if(kid2!=-1){
                seen[kid2]++;
                seen[size]++;
            }
        }

        int root=0;
        int rootCount=0;

        for(int i=0;i<size;i++){
            if(seen[i]==2){
                return false;
            }if(seen[i]==0){
                root=i;
                rootCount++;
            }
        }


        System.out.println(Arrays.toString(seen));

        if(rootCount!=1){
            return false;
        }
        seen=new int[size+1];

        
        boolean res=hasCycle(root,leftChild,rightChild,seen);



        System.out.println(rootCount);

       



        return seen[n]==n;
    }
}