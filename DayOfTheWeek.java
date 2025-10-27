class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        // I know that the first day was a friday
        //Store the days
    String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    //Store the normal amount of days in a month.. make case for leap year every 4 years
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int totalDays = 0;

        //count how many days there are of the thing we are being passed in
        for (int y = 1971; y < year; y++) {
            if ((y % 400 == 0) || (y % 4 == 0 && y % 100 != 0)){ 
                totalDays += 366;
            }
            else {
                totalDays += 365;
            } 
        }

        // Add days for months in the current year (before given month)
        for (int m = 0; m < month - 1; m++) {
            totalDays += monthDays[m];
            if (m == 1 && ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0))){
                totalDays++; // February leap day
            } 
        }

        // Add the days in the current month
        totalDays += day - 1;

        // remember jan 1 was a friday
        return days[(totalDays + 5) % 7];
    }
}