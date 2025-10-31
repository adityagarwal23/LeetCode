class Solution {
    public int minNumberOperations(int[] target) {
        //grab the first one we need to check with to do x num ops
        int operations = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                operations += target[i] - target[i - 1];
            }
        }
        return operations;
    }
}