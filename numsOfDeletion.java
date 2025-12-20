class Solution {
    public int minDeletionSize(String[] strs) {
        int stringLength = strs.length;
        int firstOne = strs[0].length();
        int numsOfDeletions = 0;

        for (int col = 0; col < firstOne; col++) {
            for (int row = 0; row < stringLength - 1; row++) {
                if (strs[row].charAt(col) > strs[row + 1].charAt(col)) {
                    numsOfDeletions++;
                    break; // move to next column
                }
            }
        }

        return numsOfDeletions;
    }
}