class Solution {
    public void merge(int[] a, int m, int[] b, int n) {
        int[] result = new int[m + n];
        int aPointer = 0;
        int bPointer = 0;
        int resultPointer = 0;
        while (aPointer < m && bPointer < n) {
            if (a[aPointer] < b[bPointer]) {
                result[resultPointer] = a[aPointer];
                aPointer++;
            } else {
                result[resultPointer] = b[bPointer];
                bPointer++;
            }
            resultPointer++;
        }
        while (aPointer < m) {
            result[resultPointer] = a[aPointer];
            aPointer++;
            resultPointer++;
        }
        while (bPointer < n) {
            result[resultPointer] = b[bPointer];
            bPointer++;
            resultPointer++;
        }
        System.arraycopy(result, 0, a, 0, a.length);
    }
}