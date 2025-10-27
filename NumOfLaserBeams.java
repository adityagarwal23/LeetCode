//solution for Number of Laser Beams in a Bank
class Solution {
    public int numberOfBeams(String[] bank) {
        int prevDevices = 0;
        int totalBeams = 0;
        for (String row : bank) {
            int devices = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') devices++;
            }

            if (devices > 0) {
                totalBeams += prevDevices * devices;
                prevDevices = devices;
            }
        }
        return totalBeams;
    }
}