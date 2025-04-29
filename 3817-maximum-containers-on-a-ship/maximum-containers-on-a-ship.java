class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int step=n*n;
        int ans=0;
        while(ans*w<= maxWeight && ans<=n*n){
            // System.out.println(ans);
                ans++;
        }return ans-1;
    }
}