class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int low = 0;
        int n = people.length;
        int high = n - 1;
        if (people[low] > limit) return boats;
        while (low < high && people[high] > limit) {
            high--;
        }
        if (low == high) {
            if (people[low] <= limit) boats++;
            return boats;
        }
        while (low < high) {
            int sum = people[low] + people[high];
            if (sum <= limit) {
                boats++;
                low++;
                high--;
            } else {
                boats++;
                high--;
            }
        }
        if (low==high && people[low] <= limit) boats++;
        return boats;
    }
}