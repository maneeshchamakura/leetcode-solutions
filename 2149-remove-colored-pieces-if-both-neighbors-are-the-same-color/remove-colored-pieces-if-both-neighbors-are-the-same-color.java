class Solution {
    public boolean winnerOfGame(String colors) {
        if (Objects.isNull(colors) || colors.length() == 0) return false;
        int alice_count = 0;
        int bob_count = 0;
        int i=0;
        while(i < colors.length()) {
            char c = colors.charAt(i);
            if (c == 'A') {
                // see how many A's you can find
                int temp = 1;
                i++;
                while(i < colors.length() && colors.charAt(i) =='A') {
                    temp++;
                    i++;
                }
                if (temp >= 3) {
                    alice_count += temp - 2;
                }
            } else {
                int temp = 1;
                i++;
                while (i < colors.length() && colors.charAt(i) == 'B') {
                    temp++;
                    i++;
                }
                if (temp >= 3) {
                    bob_count += temp - 2;
                }
            }
        }
        return alice_count > bob_count;
    }
}