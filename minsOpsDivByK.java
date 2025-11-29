class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = 0;
        //get the sum
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        int result = sum % k;
        return result;     
    }
}