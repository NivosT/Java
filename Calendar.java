/** 
* Handles calendars and calendric calculations.
*/
public class Calendar {	
	// Starting the calendar on 1/1/1900
	static int dayOfMonth = 1; 
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days on January
	
	/** Prints the calendar and the number of Sundays that fell on the first day of the month
	 * during the 20th century (from 1/1/1901 till 31/12/2000)
	 */
    public static void main(String args[]) {
		// Advances the date and the day-of-the-week from 1.1.1900 till 31.12.1900 (inclusive).
		while (year < 1901) {
			advance();
		}		
		
		int nSundaysOnFirstOfMonth = 0;
		
		// Advances the date and the day-of-the-week throughout the 20th century.
	    	// Counts Sundays that fell of the first of the month.
		
		// All the variables that it uses are the static variables defined at the class level.  
		
		while (year < 2001) {
		
			if (dayOfWeek == 1 && dayOfMonth == 1) {	// Counts Sunday && 1st of month
				nSundaysOnFirstOfMonth++;
			}
			advance();
		}
		
		System.out.print("\n" + nSundaysOnFirstOfMonth + " Sundays fell on the first of the month.");
	 }
	
	 // Advances the date and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {
		
		dayOfWeek++;									
		dayOfMonth++;
		
		if (dayOfWeek == 8) {					// Resets week count
			dayOfWeek = 1;
		}
		
		if (dayOfMonth > nDaysInMonth) {			// Resets month count
			month++;
			dayOfMonth = 1;
			if (month == 13) {
				year++;
				month = 1;
			}
			nDaysInMonth = nDaysInMonth(month, year);	// Resets amount of days each month
		} 
	 }
	 
	 /** Returns true if the given year is a leap year, false otherwise. */
	 public static boolean isLeapYear(int year) {
														
		 boolean isLeap = ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0);
		 
		 return isLeap;
	 }
		 
	 /** Returns the number of days in the given month, in the given year. */
	 public static int nDaysInMonth(int month, int year) {
		int numDays = 0;
		
		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:						// Months with always 31 days
			case 10:
			case 12:
				numDays = 31;
				break;
			case 4:
			case 6:
			case 9:						// Months with always 30 days
			case 11:
				numDays = 30;
				break;
			case 2:
				if (isLeapYear(year)) {			// Considers leap/not for February
					numDays = 29;
				}
				else {
					numDays = 28;
				}
				break;
		}	
		return numDays;
		
	 }
}
