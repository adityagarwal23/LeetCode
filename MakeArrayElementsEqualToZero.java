class Solution {
    public int countValidSelections(int[] nums) {
        int result = 0;

        for (int start = 0; start < nums.length; start++) {
            if (nums[start] != 0){ 
                continue;
            }

            //try left (-1) and right (+1)
            for (int dir = -1; dir <= 1; dir += 2) {
                int[] arr = nums.clone();
                int i = start, d = dir;

                while (i >= 0 && i < arr.length) {
                    if (arr[i] == 0){
                         i += d;
                    }
                    else {
                        arr[i]--;
                        d = -d;
                        i += d;
                    }
                }

                boolean fine = true;
                for (int n : arr)
                if (n != 0) {
                    fine = false;
                }
                if (fine){
                 result++;
                }
            }
        }
        return result;

    }
}