class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        if (arr == null || arr.length < 3) return false;
        int sum =0;
        for(int element: arr) sum += element;
        if(sum % 3 != 0) return false;
        int sumToFind = sum / 3;
        int n = arr.length;
        int prefix[] = new int[n];
        prefix[0] = arr[0];
        for (int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }
        int rightPrefix[] = new int[n];
        rightPrefix[n-1] = arr[n-1];
        for (int i=n-2; i>=0; i--) {
            rightPrefix[i] = rightPrefix[i+1] + arr[i];
        }
        int index = 0;
        while (index < n) {
            // find the 
            if (prefix[index] == sumToFind) {
                break;
            }
            index++;
        }
        if (index == n) return false;
        int rightIndex = n-1;
        while (rightIndex > index + 1) {
            if (rightPrefix[rightIndex] == sumToFind) {
                return true;
            }
            rightIndex--;
        }
        return false;
    }
}