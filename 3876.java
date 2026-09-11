class Solution {
    public boolean uniformArray(int[] nums1) {
        boolean allEven = true; 
        int min = nums1[0]; 
        for (int num : nums1) { 
            if (num % 2 != 0) { 
                allEven = false; 
            } 
                min = Math.min(min, num); 
        } 
        return allEven || min % 2 != 0;
}
}