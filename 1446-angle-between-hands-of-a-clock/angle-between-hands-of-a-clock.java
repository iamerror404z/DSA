class Solution {
    public double angleClock(int hour, int minutes) {
        double angleHourNeedle=0;
        double angleMinNeedle=0;

        double min=(double)minutes;
        double hr=(double)hour;

        if(hr==12){
            hr=0;
        }

        angleHourNeedle=(hr*30)+((min/60)*30);

        angleMinNeedle=min*6;

        double angle1=Math.abs(angleHourNeedle-angleMinNeedle);

        double angle2=(360-Math.max(angleHourNeedle,angleMinNeedle))+Math.min(angleHourNeedle,angleMinNeedle);


        // System.out.println("Angle 1 is :"+angle1);
        // System.out.println("Angle 2 is :"+angle2);

        return Math.min(angle1,angle2);
    }
}