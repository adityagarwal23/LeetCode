class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        for (int x : nums) {
            //if you need to do any of the 
            //operations then we need to increment it
            if (x % 3 != 0) {
                //increment it here for all of the times it has to appear in the array
                operations++;
            }
        }
        return operations;
    }
}