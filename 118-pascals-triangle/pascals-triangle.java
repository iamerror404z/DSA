class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> wrapped=new ArrayList<>();

        for(int i=0;i<numRows;i++){
            wrapped.add(new ArrayList<>());
        }

        wrapped.get(0).add(1);
        int size=2;


        for(int i=1;i<numRows;i++){
            
            for(int j=0;j<size;j++){
                List<Integer> up=wrapped.get(i-1);
                List<Integer> currList=wrapped.get(i);
                int left=j-1>=0?up.get(j-1):0;
                int curr=j<up.size()?up.get(j):0;

                currList.add(left+curr);

            }

            size++;
        }



        return wrapped;
        
    }
}