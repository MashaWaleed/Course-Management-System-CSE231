package project.Refined;

public class myDate {
	private int day;
    private int month;
    private int year;

    public myDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public boolean isValid() {
        if (month < 1 || month > 12)
            return false;

        int maxDays = 31; // Default to 31 days (for months with 31 days)

        if (month == 4 || month == 6 || month == 9 || month == 11)
            maxDays = 30; // April, June, September, November have 30 days
        else if (month == 2) {
            // February: Check for leap year
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
                maxDays = 29; // Leap year (February has 29 days)
            else
                maxDays = 28; // Non-leap year (February has 28 days)
        }

        return day >= 1 && day <= maxDays;
    }

    @Override
    public String toString() {
        String temp = day +"/" + month +"/" + year;
    	return temp;
    }

}
