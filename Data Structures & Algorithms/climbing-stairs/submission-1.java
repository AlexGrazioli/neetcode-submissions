class Solution {
     int[] cache;
     
    public int climbStairs(int n) {
        cache = new int[n];
        Arrays.fill(cache, -1);

        return dp(n, 0);
    }

    private int dp(int n, int i) {
        if (i > n) return 0;
        if (i == n) return 1;
        if (cache[i] != -1) return cache[i];

        return cache[i] = dp(n, i + 1) + dp(n, i + 2);
    }
}
