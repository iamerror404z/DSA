class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map=new HashMap<>();

        int index=0;
        for(String i:list1){
            map.put(i,index++);
        }


        index=0;
        int min=Integer.MAX_VALUE;
        // int count=0;

        for(String i:list2){
            if(map.containsKey(i)){
                int pos=map.get(i)+index;

                min=Math.min(min,pos);
            }

            index++;
        }

        int count=0;
        index=0;
        for(String i:list2){
            if(map.containsKey(i)){
                int pos=map.get(i)+index;

                if(pos==min){
                    count++;
                }
            }

            index++;
        }




        String[] res=new String[count];

        int r=0;
        index=0;
        for(String i:list2){
            if(map.containsKey(i)){
                int pos=map.get(i)+index;

                if(pos==min){
                    res[r++]=i;
                }
            }

            index++;
        }






        return res;
        
    }
}