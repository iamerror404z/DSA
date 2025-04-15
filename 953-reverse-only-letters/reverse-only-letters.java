class Solution {
    public String reverseOnlyLetters(String s) {
        char[] arr=s.toCharArray();
        char[]  ele=new char[s.length()];
        int size=0;
        for (char ch:arr){
            if((ch>='a' && ch<='z') ||(ch>='A' && ch<='Z')){
                ele[size++]=ch;
            }}ele=Arrays.copyOfRange(ele,0,size);
            //System.out.println(Arrays.toString(ele));
            int sz=size-1;
            for (int i=0;i<arr.length;i++){
                char ch=arr[i];
                if((ch>='a' && ch<='z') ||(ch>='A' && ch<='Z'))
                arr[i]=ele[sz--];
            }//System.out.println(Arrays.toString(arr));
            String ans="";
            for (char ch:arr){
                ans+=ch;
            }
            return ans;
        
    }
}