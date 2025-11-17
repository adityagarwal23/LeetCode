class Solution {
    public boolean kLengthApart(int[] nums, int k) {
    //prev index to check for
    int prev = -1;

    for (int i = 0; i < nums.length; i++) {
        //check if they are k apart
        if (nums[i] == 1) {
            if (prev != -1 && i - prev - 1 < k) {
                //nope not equal break.
                return false;
            }
            prev = i;
        }
    }
    return true;
    }
}