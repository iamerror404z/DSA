class Solution {
    public boolean test(int n){
        int b=n;
        while(b!=0){
            int digit=b%10;
            if(digit==0){
                return false;
            }
            if(n%digit!=0){
                return false;
            }
            b/=10;
        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> lst=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(test(i)){
                lst.add(i);
            }
        }

        return lst;
    }
}