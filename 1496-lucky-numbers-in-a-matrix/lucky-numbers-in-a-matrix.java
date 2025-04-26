class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int i,j;
        
        ArrayList<Integer> ans=new ArrayList<>();
        ArrayList<Integer> ele=new ArrayList<>();
        ArrayList<Integer> track=new ArrayList<>();
        int row=matrix.length;
        int col=matrix[0].length;
        
        for (i=0;i<row;i++){
            int min=Integer.MAX_VALUE;
            int pos=0;
            for ( j=0;j<col;j++){
                System.out.println(col+"         col: "+i);
                if(matrix[i][j] < min){min=matrix[i][j];pos=j;}}
                ele.add(min);
                track.add(pos);}

            for (i=0;i<row;i++){
                boolean found=true;
                int comp=ele.get(i);
                int pos=track.get(i);
                for (j=0;j<row;j++){
                    if(matrix[j][pos]>comp){found=false;break;}}
                    if(found){ans.add(comp);}}
            return ans;
        }
    
    
}