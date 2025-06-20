class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int[] ans=new int[2];
        int len=bobSizes.length;
        int sum=0,Alice_sum=0,Bob_sum=0;
        HashMap<Integer,Integer> Satisfy=new HashMap<>();

        for(int i:aliceSizes){
            sum+=i;
            Satisfy.put(i,i);
            Alice_sum+=i;
        }

        for (int i:bobSizes){
            sum+=i;
            Bob_sum+=i;
        }
        
        int mid=sum/2;
        int[] swap=new int[len];
        int[] required=new int[len];

        for (int i=0;i<len;i++){
            swap[i]=Alice_sum+bobSizes[i];
        }

        for (int i=0;i<len;i++){
            required[i]=swap[i]-mid;
        }

        

        for (int i=0;i<len;i++){
            if(Satisfy.getOrDefault(required[i],0)!=0){
                ans[0]=required[i];
                ans[1]=bobSizes[i];
                break;

            }
        }   

        return ans;
    }
}