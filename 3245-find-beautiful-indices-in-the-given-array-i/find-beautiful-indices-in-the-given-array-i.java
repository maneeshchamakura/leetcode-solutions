class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        
        // find the indices of a in s
        List<Integer> indices_a = new ArrayList<>();
        List<Integer> indices_b = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        if (s.length() < a.length() || s.length() < b.length()) return result;
        long a_hash = find_hash(a);
        long b_hash = find_hash(b);
        // find the indices of the a matches in s
        long temp_hash = find_hash(s.substring(0, a.length()));
        if (temp_hash == a_hash) indices_a.add(0);
        for (int i=a.length(); i < s.length(); i++) {
            temp_hash = recalculate_hash(temp_hash, s.charAt(i-a.length()), s.charAt(i), a.length());
            if (temp_hash == a_hash) {
                indices_a.add(i - a.length() + 1);
            }
        }
        // find the indices of the b matches in s
        temp_hash = find_hash(s.substring(0, b.length()));
        if (temp_hash == b_hash) indices_b.add(0);
        for (int i=b.length(); i < s.length(); i++) {
            temp_hash = recalculate_hash(temp_hash, s.charAt(i-b.length()), s.charAt(i), b.length());
            if (temp_hash == b_hash) {
                indices_b.add(i - b.length() + 1);
            }
        }
        System.out.println(indices_a);
        System.out.println(indices_b);  
        
        for (int i=0; i < indices_a.size(); i++) {
            int left = indices_a.get(i);
            for (int j=0; j < indices_b.size(); j++) {
                int right = indices_b.get(j);
                if (Math.abs(left - right) <= k) {
                    result.add(left);
                    break;
                }
            }
        }
        return result;
    }
    
    public long find_hash(String s) {
        long p=31;
        long hash = 0;
        for (int i=0; i<s.length(); i++) {
            int num = (s.charAt(i) - 'a');
            hash = hash + (num * (long)Math.pow(p, i));
        }
        return hash;
    }
    
    public long recalculate_hash(long hash, char old, char new_char, int len) {
        long p = 31;
        hash -= (old -'a');
        hash /= p;
        hash += ((new_char -'a')*(long)Math.pow(p, len - 1));
        return hash;
    }
}