class Solution {

    public int down(int index,StringBuilder[] sb,String s,int rows){
        if(index>=s.length()){
            return index;
        }

        int size=Math.min(rows,s.length()-index);

        for(int i=0;i<size && index<s.length();i++){
            sb[i].append(s.charAt(index++));
        }

        return index;
    }

    public int diagonal(int index,StringBuilder[] sb,String s,int rows){
        if(index>=s.length()){
            return index;
        }

       
        for(int i=rows-2;i>=1 && index<s.length();i--){
            sb[i].append(s.charAt(index++));
        }


        return index;
    }

    public String convert(String s, int numRows) {
        int rows=numRows;
        StringBuilder[] sb=new StringBuilder[rows];
        
        for(int i=0;i<rows;i++){
            sb[i]=new StringBuilder();
        }

        int index=0;

        while(index<s.length()){
            index=down(index,sb,s,rows);
            index=diagonal(index,sb,s,rows);
        }

        StringBuilder ans=new StringBuilder();

        for(StringBuilder i:sb){
            ans.append(i);
        }
        
        return ans.toString();
        
    }
}