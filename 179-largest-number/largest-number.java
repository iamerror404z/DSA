class Solution {

    public int countDigits(int num,int digitsCount){
        if(num==0){
            return 1;
        }

        int b=num/(int)Math.pow(10,digitsCount);
        int count=0;

        while(b!=0){
            count++;
            b/=10;
        }

        return count+digitsCount;
    }

    public String largestNumber(int[] nums) {
       StringBuilder res=new StringBuilder();
       int size=nums.length;
      


       Arrays.sort(nums);
       
       
        int digitsCount=1;
        int thresHold=10;

       int[][] processed=new int[size][2];

       for(int i=0;i<size;i++){
        if(nums[i]>=thresHold){
            digitsCount=countDigits(nums[i],digitsCount);
            thresHold=(int)Math.pow(10,digitsCount);
        
        }
        processed[i][0]=nums[i];
            processed[i][1]=digitsCount;
       }

        
        MyComp mycomp=new MyComp();
        Arrays.sort(processed,mycomp);

        for(int i[]:processed){
            System.out.println(Arrays.toString(i));
        }

        if(processed[size-1][0]==0){
            return "0";
        }
       
       for(int i=size-1;i>=0;i--){
        res.append(processed[i][0]);
       }




       return res.toString();    
    }
}


class MyComp implements Comparator<int[]>{
    @Override
    public int compare(int []a,int[] b){
        if(a[0]==b[0] && a[0]==(int)Math.pow(10,9)){
            return 0;
        }

        long num1=a[0]*(long)Math.pow(10,b[1]);
        long num2=b[0]*(long)Math.pow(10,a[1]);
        num1+=b[0];
        num2+=a[0];

        if(num1==num2){
            return 0;
        }

        if(num1>num2){
            return 1;
        }

         return -1;
    }

}