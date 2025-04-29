class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int rem=n*n;
        int ans=maxWeight/w;
        if(ans>n*n){return n*n;}
        return ans;
    }
}