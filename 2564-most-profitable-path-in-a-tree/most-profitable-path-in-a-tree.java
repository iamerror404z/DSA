class TreeNode{
    int parent ;
    Queue<int[]> edges;

    TreeNode(int parent,Queue<int[]> edges){
        this.parent=parent;
        this.edges=edges;
        
    }


}

class Solution {

    public void updateParent(int curr,int parent,TreeNode[] tree){
        tree[curr].parent=parent;

        for(int[] edge:tree[curr].edges){
            int child=edge[0]+edge[1]-curr;

            if(tree[child].parent==-1){
                updateParent(child,curr,tree);
            }

        }
        





    }


    public int maxPath(int alice,int bob,int[] 
    isVisited,int[] amount,TreeNode[] tree){
        int aliceAmount=amount[alice];
        int bobAmount=bob!=-1?amount[bob]:0;

        if(alice==bob){
            aliceAmount/=2;
            bobAmount=aliceAmount;
        }
        isVisited[alice]=1;

        int max=Integer.MIN_VALUE;

        amount[alice]=0;
        int up=-1;
        if(bob!=-1){
            amount[bob]=0;
            up=tree[bob].parent;
        }

        // making calls

        boolean isLeaf=true;

        for(int[] i:tree[alice].edges){
            int child=i[0]+i[1]-alice;
            int down=child;

            if(isVisited[child]!=1){
                    
                isLeaf=false;

                max=Math.max(max,
                maxPath(down,up,
                isVisited,amount,tree));
            }



        }

        isVisited[alice]=0;
        amount[alice]+=aliceAmount;

        if(bob!=-1){
            amount[bob]+=bobAmount;
        }

        if(isLeaf){
            return aliceAmount;
        }


        return aliceAmount+max;

    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int length=amount.length;
        TreeNode[] tree=new TreeNode[length];
        for(int i=0;i<length;i++){
            tree[i]=new TreeNode(-1,new LinkedList<>());
        }

        for(int i[]:edges){
            tree[i[0]].edges.offer(i);
            tree[i[1]].edges.offer(i);

        }

        updateParent(0,-1,tree);

        int[] isVisited=new int[length];
        int res=maxPath(0,bob,isVisited,amount,tree);



        
        return res;
    }
}