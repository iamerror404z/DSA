class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> wrapped=new LinkedList<>();
        int min=Integer.MAX_VALUE;

        for(int i=0;i<arr.length-1;i++){
            min=Math.min(min,arr[i+1]-arr[i]);
        }

        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]-arr[i]==min){
                List<Integer> inner=new LinkedList<>();
                inner.add(arr[i]);
                inner.add(arr[i+1]);
                wrapped.add(inner);

            }
        }

        
        return wrapped;
    }
}