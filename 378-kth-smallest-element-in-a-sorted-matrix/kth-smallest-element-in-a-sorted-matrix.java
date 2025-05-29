class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        ArrayList<Integer> lst=new ArrayList<>();


    for(int[] temp:matrix){
        for(int ele:temp){
            lst.add(ele);
        }
    }

    Collections.sort(lst);
    
    return lst.get(k-1);

        
       
    }
}