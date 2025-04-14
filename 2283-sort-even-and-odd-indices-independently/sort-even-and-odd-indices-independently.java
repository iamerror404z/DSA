class Solution {
    public int[] sortEvenOdd(int[] nums) {
       int size=nums.length;
        //Arrays.sort(nums);
        int[] odd=new int[size];
        int[] even=new int[size];
        int[] temp=new int[size];
        int count1=0;
        int count2=0;

        for (int i=0;i<size;i++){
            if (i%2!=0){
                System.out.println(i+" "+nums[i]);
                odd[count1++]=nums[i];
            }else{
                even[count2++]=nums[i];}}
            odd=Arrays.copyOfRange(odd,0,count1);
            even=Arrays.copyOfRange(even,0,count2);
            Arrays.sort(odd);
            Arrays.sort(even);
            
            System.out.println(Arrays.toString(odd)+" vs"+Arrays.toString(even));
            int pos2=0,pos1=count1,point=0;
            for (int j=0;j<size;j++){
                if ((j%2!=0) && (pos1>0))  {
                    temp[point++]=odd[--pos1];
                }else if (pos2<count2){
                    temp[point++]=even[pos2++];}}
                while(((pos2<count2) && (point<size)) && (pos1>count1)){
                    temp[point++]=even[pos1++];
                }while((pos1>count1) && (point<size)){
                    temp[point++]=odd[--pos1];
                }
            return  temp;
            }
}