class Solution {
    public int smallestNumber(int n) {
        //start with 1 and then we can go through it
        int x = 1; 
        //found x and now I need to mask it
        while (x < n && x > 0) { 
            // shift left once and then compare it.. now I can add it
            x = (x << 1) | 1;

            //edge case, we messed up and it went really negative
            if (x < 0) {
                return Integer.MAX_VALUE;
            }
        }
        //we have successfully found it and now i need to return it. 
        return x;
    }
}