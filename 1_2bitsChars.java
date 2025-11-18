class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        int n = bits.length;

        //keep going until you have reached the last bit
        while (i < n - 1) {  
            //grab the two bit characters
            if (bits[i] == 1) {
                i += 2;      

            } 
            //grab the one bit character
            //grab the one bit character
            else {
                i += 1;      
            }
        }

        //if we end up at the last index, that means it HAS to be the one bit characters.
        return i == n - 1;
    }
}