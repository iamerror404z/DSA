class Solution {
    static int[][] map=new int[12][12];
    
    static{
        // set the cases 
        for(int i=5;i<=8;i++){
            map[2][i]=1;
        }
        for(int i=7;i<=9;i++){
            map[4][i]=1;
            map[3][i]=1;
        }
        map[6][9]=1;
        map[5][9]=1;
        map[2][9]=2;
       
    }//casses set done



    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int length=reservedSeats.length;

        Arrays.sort(reservedSeats,(int[]a ,int[]b)->
            {
                if(a[0]!=b[0]){
                    return a[0]-b[0];
                }
                
                return a[1]-b[1];
            }

        );

       
        int groups=0;

        int prevRow=1;
        int prevSeat=1;
        for(int i=0;i<length;i++){
            

            int currRow=reservedSeats[i][0];
            int currSeat=reservedSeats[i][1];

            if(currRow!=prevRow){
                // part1 settle down the prevRow 
                int low=prevSeat+1;
                int end=9;

                groups+=map[low][end];
                System.out.println("prev sum is : "+map[low][end]);

                // part2 settle down the missing rows
                int rowsSkipped=Math.max(0,currRow-prevRow-1);
                System.out.println("rows skipped is : "+rowsSkipped);
                groups+=(rowsSkipped*2);


                prevRow=currRow;
                prevSeat=1;

            }

            int low=prevSeat+1;
            int end=currSeat-1;

            int currGroups=map[low][end];

            System.out.println("index is  :"+i);
            System.out.println("currgroups is : "+currGroups);
            prevSeat=currSeat;
            groups+=currGroups;
        }
        // settle down the prev row
        groups+=(map[prevSeat+1][9]);

        // Process the remaining the rows
        int rowsSkipped=Math.max(0,n-prevRow);
        

        groups+=(rowsSkipped*2);
        // for(int i[]:reservedSeats){
        //     System.out.println(Arrays.toString(i));
        // }

        return groups; 
    }
}