class Solution {

    public String reverseWords(String s) {
        if (Objects.isNull(s) || s.length() == 0) return s;
        char[] char_array = s.toCharArray();
        int first_non_space = 0;
        int i=0;
        int n = s.length();
        while (i < n) {
            // find the space character            
            i++;
            while(i<n && s.charAt(i) != ' ') {
                i++;
            }
            // first_non_space till i-1
            // reverse between first_non_space and i-1
            reverse(char_array, first_non_space, i-1);
            first_non_space = i+1;          
        }
        return String.valueOf(char_array);
    }

    public void reverse(char[] char_array, int start, int end) {
        while (start < end) {
            char temp = char_array[start];
            char_array[start] = char_array[end];
            char_array[end] = temp;
            start+=1;
            end-=1;
        }
    }
}