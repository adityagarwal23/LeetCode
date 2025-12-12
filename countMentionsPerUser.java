import java.util.*;

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {

        //making another class because there is so much to store.
        class E {
            String type;
            int timestamp;
            String arg;
            E(String t, int ts, String a) {
                type = t; timestamp = ts; arg = a;
            }
        }


        //setting  up some sizes
        int n = events.size();
        E[] arr = new E[n];

        // Extract event elements
        for (int i = 0; i < n; i++) {
            List<String> e = events.get(i);
            String type = e.get(0);
            int timestamp = Integer.parseInt(e.get(1));
            String arg = e.get(2);             // id OR mentions_string
            arr[i] = new E(type, timestamp, arg);
        }

        // Sort events:
        // i need to go by time stamp first
        // we go offline if the message is equals.
        Arrays.sort(arr, (a, b) -> {
            if (a.timestamp != b.timestamp){
                 return a.timestamp - b.timestamp;
            }
            if (a.type.equals("OFFLINE") && b.type.equals("MESSAGE")) {
                return -1;
            }
            if (a.type.equals("MESSAGE") && b.type.equals("OFFLINE")) {
                return 1;
            }
            return 0;
        });


        //mentions or onlines.
        int[] mentions = new int[numberOfUsers];
        boolean[] online = new boolean[numberOfUsers];
        int[] recoverAt = new int[numberOfUsers];

        // Initialize
        for (int i = 0; i < numberOfUsers; i++) {
            online[i] = true;
            recoverAt[i] = -1;
        }

        // Process events
        for (E e : arr) {

            int t = e.timestamp;

            // recover users before they end.
            for (int u = 0; u < numberOfUsers; u++) {
                if (!online[u] && recoverAt[u] != -1 && recoverAt[u] <= t) {
                    online[u] = true;
                }
            }

            if (e.type.equals("OFFLINE")) {
                int user = Integer.parseInt(e.arg);
                online[user] = false;
                recoverAt[user] = t + 60;
            }

            //for messaging
            else { 
                String[] tokens = e.arg.split(" ");
                for (String tok : tokens) {

                    if (tok.equals("ALL")) {
                        // All users (online or offline)
                        for (int u = 0; u < numberOfUsers; u++) {
                            mentions[u]++;
                        }
                    }

                    else if (tok.equals("HERE")) {
                        // Only online users
                        for (int u = 0; u < numberOfUsers; u++) {
                            if (online[u]) mentions[u]++;
                        }
                    }

                    else if (tok.startsWith("id")) {
                        int user = Integer.parseInt(tok.substring(2));
                        mentions[user]++; // even if offline
                    }
                }
            }
        }

        return mentions;
    }
}
