class Solution {
    public boolean canBeEqual(String s1, String s2) {
        Set<Character> first = new HashSet<>();
        Set<Character> second = new HashSet<>();
        first.add(s1.charAt(0));
        first.add(s1.charAt(2));
        second.add(s2.charAt(0));
        second.add(s2.charAt(2));
        if (!first.equals(second)) return false;
        
        first = new HashSet<>();
        second = new HashSet<>();
        first.add(s1.charAt(1));
        first.add(s1.charAt(3));
        second.add(s2.charAt(1));
        second.add(s2.charAt(3));
        return first.equals(second);
    }
}