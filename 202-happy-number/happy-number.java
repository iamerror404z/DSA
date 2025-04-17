class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen=new HashSet<>();
        int sum=0;
        int digit=0;
        int b=n;
        while(sum!=1){
            while(b!=0){
                digit=b%10;
                sum+=digit*digit;
                b/=10;}
        System.out.println(sum);
        if(seen.contains(sum) || sum==1){
            break;
        }else{
            seen.add(sum);
        }b=sum;
        sum=0;}
        if(sum==1){ return true;}
        return false;    
    }
}