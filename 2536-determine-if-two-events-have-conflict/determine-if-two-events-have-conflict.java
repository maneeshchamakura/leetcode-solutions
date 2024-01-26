class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int[] int1 = convertToMinutes(event1);
        int[] int2 = convertToMinutes(event2);
        if(int1[0] > int2[0]) {
            int[] temp= int1;
            int1 = int2;
            int2 = temp;
        }
        if (int2[0] >= int1[0] && int2[0] <= int1[1]) return true;
        return false;
    }
    
    public int[] convertToMinutes(String[] event) {
        int[] arr = new int[2];
        String[] parts = event[0].split(":");
        int minutes = Integer.parseInt(parts[0])*60 + Integer.parseInt(parts[1]);
        arr[0] = minutes;
        parts = event[1].split(":");
        arr[1] = Integer.parseInt(parts[0])*60 + Integer.parseInt(parts[1]);
        return arr;
    }
}