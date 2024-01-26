class Solution {
    public int longestSubstring(String s, int k) {
        return longestSubstringUtil(s, 0, s.length(), k);
    }

    public int longestSubstringUtil(String s, int start, int end, int k) {
        // not enough characters
        if (end < k) return 0;
        int[] countMap = new int[26];
        for(int i=start; i < end; i++) countMap[s.charAt(i) - 'a']++;
        for (int mid = start; mid < end; mid++) {
            if (countMap[s.charAt(mid) - 'a'] >= k) continue;
            // invalid character
            int midNext = mid + 1;
            // ignore the mid values that you are invalid characters
            while (midNext < end && countMap[s.charAt(midNext) - 'a'] < k)
            midNext+= 1;
            return Math.max(
                longestSubstringUtil(s, start, mid, k),

                longestSubstringUtil(s, midNext, end, k)
            );
        }
        return end - start;
    }
}