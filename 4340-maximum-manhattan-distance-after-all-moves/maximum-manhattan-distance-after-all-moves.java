class Solution {
    public int maxDistance(String moves) {
        int[] dir=new int[4];

        

        int changes=0;

        for(char ch:moves.toCharArray()){
            switch (ch) {
            case '_':
                changes++;
        break;

    case 'U':
        dir[0]++;
        break;

    case 'D':
        dir[1]++;
        break;

    case 'L':
        dir[2]++;
        break;

    default:
        dir[3]++;
        break;
}
        }

        int upDown=Math.abs(dir[0]-dir[1]);
        int leftRight=Math.abs(dir[2]-dir[3]);



        




        return upDown+leftRight+changes;
    }
}