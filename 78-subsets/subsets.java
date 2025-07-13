class Solution {
    List<List<Integer>> ans=new ArrayList<List<Integer>>();
        
    public void subset_TUF(int index,List<Integer> lst,int[] arr,int limit,List<List<Integer>> wrap){
        if(index>=limit){
            wrap.add(new ArrayList<>(lst));
            System.out.println(wrap);
            return;
        }
        lst.add(arr[index]);
        subset_TUF(index+1,lst,arr,limit,wrap);
        lst.remove(lst.size()-1);
        subset_TUF(index+1,lst,arr,limit,wrap);
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> lst=new ArrayList<>();
        subset_TUF(0,lst,nums,nums.length,ans);



        return ans;

        
    }
}