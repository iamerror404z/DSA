class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");

        int pointer1=0;
        int pointer2=0;

        while(pointer1<v1.length && pointer2<v2.length){
            int num1=Integer.parseInt(v1[pointer1++]);
            int num2=Integer.parseInt(v2[pointer2++]);

            if(num1<num2){
                return -1;
            }

            if(num1>num2){
                return 1;
            }

        }

        while(pointer1<v1.length){
            int num1=Integer.parseInt(v1[pointer1++]);
            
            if(num1>0){
                return 1;
            }
        }


        while(pointer2<v2.length){
            int num2=Integer.parseInt(v2[pointer2++]);

            if(num2>0){
                return -1;
            }
        }


        return 0;
    }
}