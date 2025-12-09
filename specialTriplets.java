class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        //we have to mod it to 10^9 + 7
        int MOD = 1000000007;

        // Count how many times each number appears to the right
        int max = 0;
        for (int x : nums) {
            if (x > max) {
                max = x;
            }
        }

        //go through the right
        int[] right = new int[max + 1];
        for (int x : nums) {
            right[x]++;
        }

        int answer = 0;
        int[] left = new int[max + 1];

        for (int j = 0; j < n; j++) {
            int val = nums[j];
            right[val]--;  // this index moves from right to middle

            int half = val * 2;
            if (half <= max) {
                int countLeft = left[half];
                int countRight = right[half];


                //this check is AI. i was failing :(
                if (countLeft > 0 && countRight > 0) {
                    answer = (int)((answer + (long)countLeft * countRight) % MOD);
                }
            }

            left[val]++;  // now available to left side
        }

        return answer;
    }
}