class Solution {
    public int totalNumbers(int[] digits) {
        int[] freq = new int[10];

        // Count how many copies of each digit we have
        for (int i = 0; i < digits.length; i++) {
            freq[digits[i]]++;
        }

        int count = 0;

        // Try every possible three-digit number
        for (int num = 100; num <= 999; num++) {

            // Must be even
            if (num % 2 != 0) {
                continue;
            }

            int ones = num % 10;
            int tens = (num / 10) % 10;
            int hundreds = num / 100;

            // Count the digits needed for this number
            int[] needed = new int[10];
            needed[ones]++;
            needed[tens]++;
            needed[hundreds]++;

            // Check if we have enough copies
            boolean possible = true;

            for (int d = 0; d < 10; d++) {
                if (needed[d] > freq[d]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;
    }
}