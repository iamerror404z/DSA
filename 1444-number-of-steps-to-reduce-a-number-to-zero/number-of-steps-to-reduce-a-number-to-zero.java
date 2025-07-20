class Solution {
    int step=0;
    int ans=0;
    public void stepCalc(int num,int step){
        if(num==0){
            if(ans==0){
                ans=step;
            }
            return ;
        }if(num%2==0 &&ans==0){
            stepCalc(num/2,step+1);
        }if(ans==0){
         stepCalc(num-1,step+1);}
    }
    public int numberOfSteps(int num) {
        if(num==0){
            return 0;
        }
        stepCalc(num,step);

        return ans;

    }
}