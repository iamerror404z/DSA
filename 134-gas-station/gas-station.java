class Solution {
     public int  canCompleteCircuit(int[] gas, int[] cost) {
            int ans=0;
            int t_gases=0;
            int t_costs=0;
            int bal;
            for (int i=0;i<gas.length;i++){
                t_gases+=gas[i];
                t_costs+=cost[i];
            }if(t_costs>t_gases){
                return -1;}
            bal=0;
            for (int j=0;j<gas.length;j++){
                bal+=gas[j]-cost[j];
                if(bal<0){
                    bal=0;
                    ans=j+1;
               }}
            
        return ans;  
    }
}