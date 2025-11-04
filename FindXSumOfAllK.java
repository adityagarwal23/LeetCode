class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        //go through the entire subarray
        for (int i = 0; i <= n - k; i++) {
            //appearance in window and update
            HashMap<Integer, Integer> count = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                count.put(nums[j], count.getOrDefault(nums[j], 0) + 1);
            }

            //sorting time
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>(count.entrySet());

            //sort freq then val... help from ai on this :/ i couldn't really figure out this part
            Collections.sort(list, (a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    return b.getValue() - a.getValue();
                } else {
                    return b.getKey() - a.getKey();
                }
            });

            //add up to the most frequent elemetns
            int sum = 0;
            int added = 0;
            for (Map.Entry<Integer, Integer> e : list) {
                if (added == x){
                    break;
                }
                sum += e.getKey() * e.getValue();
                added++;
            }

            result[i] = sum;
        }

        return result;

    }
}