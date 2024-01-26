class Solution {
    public String entityParser(String text) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        // &amp; should be replaced at last as it could introduce new entities        
        map.put("&amp;", "&");
        if (text == null || text.isEmpty()) return text;
        for (String key: map.keySet()) {
            text = text.replaceAll(key, map.get(key));
        }
        return text;
    }
}