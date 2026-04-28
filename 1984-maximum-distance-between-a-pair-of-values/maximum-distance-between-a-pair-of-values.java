class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max=0;
        int size1=nums1.length;
        int size2=nums2.length;

        int i=0;

        for(int j=0;j<size2;j++){
            while(i<size1-1 && nums1[i]>nums2[j] && i<=j){
                i++;
            }

            

            if(i<=j && nums1[i]<=nums2[j]){
                max=Math.max(max,j-i);
            }


        }



        return max;
        
    }
}