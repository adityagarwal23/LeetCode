class Solution {
    public int countTriples(int n) {
        int count = 0;

        // i think i can use euclids formula


        for (int m = 2; m * m <= n; m++) {
            for (int a = 1; a < m; a++) {

                // must have opposite parity to continue
                if ((m + a) % 2 != 1) {
                    continue;
                }

                // must ALSO be coprime
                if (gcd(m, a) != 1) {
                    continue;
                }

                int x = m*m - a*a;   //first side
                int y = 2*m*a;       // second side
                int z = m*m + a*a;   // hypotenuse

                if (z > n) {
                    continue;
                }

                int k = 1;
                while (k * z <= n) {
                    int A = k * x;
                    int B = k * y;
                    int C = k * z;

                    if (A <= n && B <= n) {
                        // count (A, B, C) and (B, A, C)
                        //because they are the same but like also different 
                        count += 2;
                    }

                    k++;
                }
            }
        }

        return count;
    }

    //yeah i need the gcd
    private int gcd(int x, int y) {
        while (y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}