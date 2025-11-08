class Solution {
    public List<List<Integer>> answer(int[] arr){
        List<List<Integer>> outer=new LinkedList<>();
        int start=0;
        int end=0;
        outer.add(new LinkedList<>());

        for(int  i=0;i<arr.length;i++){
            start=0;
            if(i>0 && arr[i]==arr[i-1]){
                System.out.println(end+1);
                start=end;
            }

            end=outer.size();
            for(int j=start;j<end;j++){
                List<Integer> inner=new LinkedList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        
        }



        return outer;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        

        return answer(nums);
    }
}