class Solution {
    
    
    public void sort(int start,int end,int[] address,int[] mem){
        int size=end-start+1;
        int[] temp=new int[size];
        
        int pointer1=start;
        
        int mid=start+(end-start)/2;
        
        
        int pointer2=mid+1;
        
        int resPointer=0;
        
        
        while(pointer1<=mid && pointer2<=end){
            int num1=mem[address[pointer1]];
            int num2=mem[address[pointer2]];
            
            if(num1<=num2){
                temp[resPointer]=address[pointer1];
                resPointer++;
                pointer1++;
            }else{
                
                temp[resPointer]=address[pointer2];
                resPointer++;
                pointer2++;
            }
            
        }
        
        while(pointer1<=mid){
            temp[resPointer++]=address[pointer1++];
        }
        while(pointer2<=end){
               temp[resPointer++]=address[pointer2++];
        }
        
        
        for(int i=start;i<=end;i++){
            address[i]=temp[i-start];
        }
        
        
    }
    
    
    public void merge(int start,int end,int[] address,int[] mem){
        if(start>=end){
            return ;
        }
        
        int mid=start+(end-start)/2;
        
        merge(start,mid,address,mem);
        merge(mid+1,end,address,mem);
        
        sort(start,end,address,mem);
    }

    public int process(int[] nums,int start){

        while(start<nums.length && nums[start]==-1){
            start++;
        }

        return start;
    }
    
    
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int length=nums1.length;
        int[] res=new int[length];
        
        int address[]=new int[length];

        for(int i=0;i<length;i++){
            address[i]=i;
        }
        
        

        Arrays.fill(res,-1);
        Arrays.sort(nums1);

        merge(0,length-1,address,nums2);


        int pointer=0;
        
        for(int i=0;i<length;i++){
            int curr1=nums1[i];
            int ref=address[pointer];
            int curr2=nums2[ref];
            
            res[ref]=curr1;


            if(curr1>curr2){
                nums1[i]=-1;
                pointer++;
            }


        }

        // addressing the unused values !

        pointer=0;

        for(int i=0;i<length;i++){
            int curr=res[i];
            
            if(curr==-1){
                pointer=process(nums1,pointer);
                res[i]=nums1[pointer];
                pointer++;
            }

        }


        

        

        
        return res;
    }
}