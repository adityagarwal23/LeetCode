class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        //keeping track of it
        int[] count = new int[nums.length];
        //we know we will ALWAYS have 2 
        int[] result = new int[2];
        //looping through and then updating if we have
        //found the bad number
        int idx = 0;

        //run through it and append to the new array as necessary
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
            if (count[nums[i]] == 2) {
                result[idx++] = nums[i];
            }
        }
        return result;
    }
}