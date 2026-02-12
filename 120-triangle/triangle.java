class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> wrapped=new LinkedList<>();
        int length=triangle.size();
        
        for(int i=0;i<length-1;i++){
            List<Integer> inner=new LinkedList<>(Collections.nCopies(i+1,0));
            wrapped.add(inner);
         
        }
        wrapped.add(new LinkedList<>(triangle.get(length-1)));

        for(int i=length-2;i>=0;i--){
            int size=triangle.get(i).size();

            for(int j=size-1;j>=0;j--){
                int min=Math.min(wrapped.get(i+1).get(j),wrapped.get(i+1).get(j+1));
                int value=triangle.get(i).get(j);
                wrapped.get(i).set(j,value+min);

            }
        }









        return wrapped.get(0).get(0);

    }
}