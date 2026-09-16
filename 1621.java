class Solution {
    private static final long MOD = 1_000_000_007L;

    public int numberOfSets(int n, int k) {
        // Need at least k segments, each containing 2 points.
        // With shared endpoints, k segments require at least k + 1 points.
        if (n < k + 1) {
            return 0;
        }

        int max = n + k - 1;

        long[] fact = new long[max + 1];
        long[] invFact = new long[max + 1];

        fact[0] = 1;
        for (int i = 1; i <= max; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }

        invFact[max] = modPow(fact[max], MOD - 2);

        for (int i = max - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }

        // C(n + k - 1, 2k)
        return (int) combination(n + k - 1, 2 * k, fact, invFact);
    }

    private long combination(int n, int r, long[] fact, long[] invFact) {
        if (r < 0 || r > n) {
            return 0;
        }

        return fact[n] * invFact[r] % MOD
                * invFact[n - r] % MOD;
    }

    private long modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }

            base = base * base % MOD;
            exp >>= 1;
        }

        return result;
    }
}