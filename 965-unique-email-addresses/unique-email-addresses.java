class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> address = new HashSet<>();
        for(String email: emails) {
            String[] parts = email.split("@");
            StringBuffer sb = new StringBuffer("");
            int index =0;
            while (index < email.length()) {                
                char c = email.charAt(index);
                if (c == '@') break;
                if (c == '+') break;
                else if (c != '.'){
                    sb.append(c);                    
                }
                index++;
            }
            sb.append("@");
            sb.append(parts[1]);
            address.add(sb.toString());
        }
        System.out.println(address);
        return address.size();
    }
}