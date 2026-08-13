class Solution {

    public boolean isPossible(int[] dist, long hourScaled, int speed) {
        long timeScaled = 0; // hours * 100, integer-exact
        int n = dist.length;

        for (int i = 0; i < n - 1; i++) {
            int hrs = (dist[i] + speed - 1) / speed; // ceil, exact (integer division here is fine — no fraction lost)
            timeScaled += (long) hrs * 100;
            if (timeScaled > hourScaled) return false;
        }

        long remainingScaled = hourScaled - timeScaled;


        // check dist[n-1]/speed <= remainingScaled/100  <=>  dist[n-1]*100 <= remainingScaled*speed
        return (long) dist[n - 1] * 100 <= remainingScaled * (long) speed;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (n - 1 > hour) return -1;

        long hourScaled = Math.round(hour * 100);

        int start = 1, end = (int) 1e7, speed = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(dist, hourScaled, mid)) {
                speed = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return speed;
    }
}