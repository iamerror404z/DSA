class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] freq=new int[1001];
        int[] temp=new int[1001];
        int max=-1;
        // int max= Math.max(nums1.length,nums2.length);
        for (int i:nums1){
            if (max<i){max=i;}
            freq[i]=1;}
        int pos=0;
        for (int j:nums2){
            // System.out.println(j+" "+freq[j]);
            if(freq[j]>0){
                temp[pos++]=j;
                    --freq[j];}}
        int[] ans=new int[pos];
        int pt=0;
        for(int l=0;l<pos;l++){
            ans[pt++]=temp[l];}
        System.out.println(Arrays.toString(ans)+"  "+pos);
        return ans;
}}
