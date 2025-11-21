import java.util.HashMap;
class Solution {
    public int countPalindromicSubsequence(String s) {
        //store how long the string given is
        int n = s.length();
        
        //i think hashmaps are the best? store first and last positions of each character
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> last  = new HashMap<>();
        
        //how many times do they appear
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            //ai helped with this method finder.
            first.putIfAbsent(c, i);
            last.put(c, i);
        }

        int result = 0;

        //appearance then you get it
        for (char c : first.keySet()) {
            int start = first.get(c);
            int end   = last.get(c);

            //one char MUST exist between each
            if (start < end) {
                Set<Character> middleChars = new HashSet<>();
                
                for (int i = start + 1; i < end; i++) {
                    middleChars.add(s.charAt(i));
                }
                
                //palindrome for c x c
                result += middleChars.size();
            }
        }
        //return it.
        return result;
    }
}