class Solution {
    public long maxProduct(int[] nums) {
        int size=nums.length;
        int[] temp=new int[size];

        for(int i=0;i<size;i++){
            temp[i]=Math.abs(nums[i]);
        }

        Arrays.sort(temp);

        int min=temp[size-1];
        int pos=size-1;
        for(int i=size-3;i<size;i++){
            if(temp[i]<min){
                min=temp[i];
                pos=i;
            }
        }

        long product=1;

        for(int i=size-3;i<size;i++){
            if(i!=pos){
                product*=(long)temp[i];
            }
        }
        
        long max=Long.MAX_VALUE;
        long div=0;

        if(product!=0){
         div=max/product;}
        long choosen=Math.min(div,(long)Math.pow(10,5));

        product*=choosen;

        return  product;
    }
}