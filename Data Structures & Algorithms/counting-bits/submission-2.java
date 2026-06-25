class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        
        if  (n == 0) {
            result[0] = 0;
            return result;
        }
        
        int offset = 1;
        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            if (offset * 2 == i) offset = i;
            result[i] = 1 + result[i - offset];
        }

        return result;
    }
}
