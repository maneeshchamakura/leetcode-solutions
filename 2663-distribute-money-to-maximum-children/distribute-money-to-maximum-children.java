class Solution {
    public int distMoney(int money, int children) {
        // first condition fails
        if (money < children) return -1;
        // satisfy the first condition
        money -= children;
        // try satisying the second condition
        int count_7 = money/7 ;
        if (count_7 > children) count_7 = children;
        int rem_money = money - count_7*7;
        if (rem_money == 0) return count_7;
        if (rem_money == 3) {
            int rem_child = children - count_7;
            if (rem_child <= 1) {
                return count_7 - 1;
            } else {
                return count_7;
            }
        } else {
            int rem_child = children - count_7;
            if (rem_child == 0) {
                return count_7 - 1;
            } else {
                // 1 2 4 5 6 ...
                return count_7;
            }
        }
    }
}