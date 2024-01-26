class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {        
        // find the indices of a in s
        List<Integer> indices_a = new ArrayList<>();
        List<Integer> indices_b = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        // find the indices of a in s
        indices_a = strStr(s, a);
        indices_b = strStr(s, b);
        // System.out.println("indices" + indices_a);
        // System.out.println(" indices b" + indices_b);
        if (indices_a.size() < 1 || indices_b.size() < 1) return result;
        for (int i=0; i<indices_a.size(); i++) {
            int index = indices_a.get(i);
            int index1 = find_greater_than(indices_b, index - k - 1);
            int index2 = find_greater_than(indices_b, index + k);
            System.out.println(index1 + "," + index2 + ":" + (index - k - 1) + "," + (index + k + 1));
            if (index2 - index1 >= 1) {
                result.add(index);
            }
        }
        return result;
    }
    
    public int find_greater_than(List<Integer> alist, int target) {
        int low = 0;
        int high = alist.size() - 1;
        while (low < high) {
            int mid = low + (high - low)/2;
            if (alist.get(mid) > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return alist.get(low) > target ? low : low + 1;
    }
    
    public List<Integer> strStr(String s, String a) {
        if (a.length() > s.length()) return new ArrayList<>(); 
        List<Integer> ans = new ArrayList<>();
        long target = 0;
        for (int i = 0; i<a.length(); i++) {
            target = (target * 31 + a.charAt(i) - 'a');
        }
        long cur = 0;
        long aL = 1;
        int L = a.length();
        for (int i = 1; i <= L; ++i) aL = (aL * 31) ;
        for (int i = 0; i<L; i++) {
            cur = (cur * 31 + s.charAt(i) - 'a');
        }
        if (cur == target) ans.add(0);
        for (int i = L; i<s.length(); i++) {
                cur = (cur * 31 - aL * (s.charAt(i-L) - 'a'));
                cur = (cur + s.charAt(i) - 'a');
                if (cur == target) {
                    ans.add(i - (a.length() - 1));
                } 
        }
        return ans;
    }
    
    public List<Integer> find_substring(String pattern, String text) {
        int[] lps = compute_lps(pattern);
        List<Integer> result = new ArrayList<>();
        int j = 0;
        int n = text.length();
        for (int i=0; i<n; i++) {
            if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                if (j == pattern.length()) {
                    // add answer to the list
                    result.add(i - pattern.length() +1);
                    // abcdabc
                    j = lps[j-1];
                    // abcda
                }
                // handle reaching the end
            } else {
                // change j to the index
                while (j != 0 && text.charAt(i) != pattern.charAt(j)) {
                    j = lps[j-1];
                }
                if (pattern.charAt(j) == text.charAt(i)) {
                    j++;
                    if (j == pattern.length()) {
                        // add answer to the list
                        result.add(i - pattern.length() +1);
                        j = lps[j-1];
                    }
                }
            }
        }
        return result;
    }
    
    public int[] compute_lps(String pattern) {
        // a b c a a y
        // 0 
        // j = 0
        // i = 1
        int j=0;
        int n = pattern.length();
        int[] lps = new int[n];
        for (int i=1; i<pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == pattern.charAt(j)) {
                lps[i] = j + 1;
                j++;
            } else {
                while (j != 0 && c != pattern.charAt(j)) {
                    j = lps[j-1];
                }
                if (pattern.charAt(j) == c) {
                    lps[i] = j + 1;
                    j++;
                } else {
                    lps[i] = 0;
                }
            }
        }
        return lps;
    }
}