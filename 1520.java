import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] first = new int[26];
        int[] last = new int[26];

        Arrays.fill(first, n);
        Arrays.fill(last, -1);

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            first[c] = Math.min(first[c], i);
            last[c] = i;
        }

        List<int[]> intervals = new ArrayList<>();

        for (int left = 0; left < n; left++) {
            int c = s.charAt(left) - 'a';
            if (first[c] != left) {
                continue;
            }

            int right = getRightBoundary(s, left, first, last);

            if (right == -1) {
                continue;
            }

            if (intervals.isEmpty() ||
                left > intervals.get(intervals.size() - 1)[1]) {

                intervals.add(new int[]{left, right});

            } else {
                intervals.set(
                    intervals.size() - 1,
                    new int[]{left, right}
                );
            }
        }

        List<String> result = new ArrayList<>();

        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];

            result.add(s.substring(left, right + 1));
        }

        return result;
    }

    private int getRightBoundary(
        String s,
        int left,
        int[] first,
        int[] last
    ) {
        int c = s.charAt(left) - 'a';

        int right = last[c];

        for (int i = left; i <= right; i++) {
            int current = s.charAt(i) - 'a';

            if (first[current] < left) {
                return -1;
            }
            right = Math.max(right, last[current]);
        }

        return right;
    }
}