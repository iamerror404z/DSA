class Solution {

    public int revNumber(int num){
        int res=0;

        while(num!=0){
            int d=num%10;
            res+=d;
            res*=10;

            num/=10;
        }
        res/=10;


        return res;
    }



    public int countDistinctIntegers(int[] nums) {
        int length=nums.length;
        Map<Integer,Integer> map=HashMap.newHashMap(length);
        int uniqueElement=0;




        for(int i:nums){
            int rev=revNumber(i);

            if(!map.containsKey(i)){
                map.put(i,1);
                uniqueElement++;
            }

            if(!map.containsKey(rev)){
                map.put(rev,1);
                uniqueElement++;
            }

        }
        




        return uniqueElement;
    }
}