class Solution {
    public long getDescentPeriods(int[] prices) {
        //day0
        //apparently you need to make it a long
        //otherwise i fail 2 test cases ://
        long answer = 1;   
        long len = 1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                len++;
            } else {
                len = 1;
            }
            answer += len;
        }

        return answer;
    }
}