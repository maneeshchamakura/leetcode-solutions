class Solution {
    public int numRabbits(int[] answers) {
        int res = answers.length;
        Arrays.sort(answers);
        int n = answers.length;
        int index = n-1;
        while (index >= 0) {
            // find the count of answers[index]
            int count = 0;
            int num = answers[index];
            while(index >= 0 && answers[index] == num) {
                count++;
                index--;
            }
            res += get_extra_rabbits(num, count);
        }
        return res;
    }
    int get_extra_rabbits(int n, int count) {
        count--;
        count = count % (n + 1);
        return n - count;
    }
}