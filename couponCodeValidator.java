import java.util.*;
class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        //the order its going to be in
        String[] order = {"electronics", "grocery", "pharmacy", "restaurant"};

        // Map each valid business line to its list of codes
        Map<String, List<String>> map = new HashMap<>();
        for (String b : order) {
            map.put(b, new ArrayList<>());
        }

        //easier variable
        int n = code.length;

        for (int i = 0; i < n; i++) {

            //MUST be active
            if (!isActive[i]) {
                continue;
            }

            //MUST be valid businessLine
            if (!map.containsKey(businessLine[i])) {
                continue;
            }

            //MUST be valid code
            if (!isValidCode(code[i])) {
                continue;
            }

            map.get(businessLine[i]).add(code[i]);
        }

        //time to start with result
        List<String> result = new ArrayList<>();

        for (String b : order) {
            List<String> list = map.get(b);
            Collections.sort(list);
            result.addAll(list);
        }

        return result;
    }

    //non empty alphabetically or _  case
    private boolean isValidCode(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (!(Character.isLetterOrDigit(c) || c == '_')) {
                return false;
            }
        }
        return true;
    }
}