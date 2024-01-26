class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        int[] arr = get_array(needle);
        System.out.println(Arrays.toString(arr)) ;
        int j=0;
        for (int i=0; i<haystack.length(); i++) {
            char c = haystack.charAt(i);
            if (c == needle.charAt(j)) {
                j++;
            } else {
                if (j > 0) {
                    while (j > 0) {   
                        j = arr[j-1];                 
                        if (c == needle.charAt(j)) {                            
                            j++;
                            break;
                        }
                    }
                }
                if (j == 0) {
                    if (c == needle.charAt(j)) {
                        j++;
                    }
                }
            }
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }
        }
        return -1;
    }

    int[] get_array(String s) {
        int n = s.length();
        int[] arr = new int[n];
        int j = 0, i=1;
        while (i < n) {
            if (s.charAt(j) == s.charAt(i)) {
                arr[i] = j + 1;
                j++;
            } else {
                while (j > 0) {
                    j = arr[j-1];
                    if (s.charAt(j)== s.charAt(i)) {
                        arr[i] = j + 1;
                        j++;
                        break;
                    }
                }
                if (j < 0) arr[i] = 0;
            }
            i++;
        }
        return arr;
    }

}