class Solution {
    public int minSubarray(int[] nums, int p) {
        int total = 0;
        //total of the array
        for (int i = 0; i < nums.length; i++) {
            total = (total + nums[i]) % p;
        }

        int target = total % p;
        //none to remove
        if (target == 0) {
            return 0;
        }

        //we have something to remvoe, keep track of it
        HashMap<Integer, Integer> myMap = new HashMap<>();
        myMap.put(0, -1);

        int prefix = 0;
        int result = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            int needed = prefix - target;
            needed = needed + p;
            needed = needed % p;

            if (myMap.containsKey(needed)) {
                int len = i - myMap.get(needed);
                if (len < result) {
                    result = len;
                }
            }
            //found the item to put and then we can get the length
            myMap.put(prefix, i);
        }

        //impossible case first, otherwise return it.
        if (result == nums.length) {
            return -1;
        } else {
            return result;
        }
    }
}