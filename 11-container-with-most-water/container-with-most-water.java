class Solution {
    public int maxArea(int[] height) {
        int length=height.length;
        
        int start=0;
        int end=height.length-1;
        
        int max=0;
        
        while(start<end){
            int leftBar=height[start];
            int rightBar=height[end];
            
            int width=end-start;
            
            int cap=width*Math.min(leftBar,rightBar);
            max=Math.max(max,cap);
            
            if(leftBar>=rightBar){
                end--;
            }else{
                start++;
            }
            
        }
        
        
        
        return max;
        
    }
}