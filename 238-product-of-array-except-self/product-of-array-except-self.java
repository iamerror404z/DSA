import java.util.*;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len=nums.length;
        if(len==1)
            return nums;
        
        int[] prefix=new int[len];
        int[] postfix=new int[len];
        prefix[0]=1;
        for(int i=1;i<len;i++){
            prefix[i]=prefix[i-1]*nums[i-1];
        }
        
        postfix[len-1]=1;
        for(int i=len-2;i>=0;i--){
            postfix[i]=postfix[i+1]*nums[i+1];
        }
        System.out.println(Arrays.toString(postfix));

        int[] ans=new int[len];

        for(int i=0;i<len;i++){
            ans[i]=prefix[i]*postfix[i];
        }

        return ans;
    }
}