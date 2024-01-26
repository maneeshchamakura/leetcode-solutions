class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long min = 1;
        long max = Arrays.stream(time).min().orElseThrow();
        max *= totalTrips;
        while (min < max) {
            long mid = min + (max - min)/2;
            // find the number trips less than mid
            long count = 0;
            for(int num: time) {
                count += (mid/num);
            }
            if (count < totalTrips) {
                min = mid + 1;
            } else {          
                max = mid;
            }
        }
        return min;
    }
}