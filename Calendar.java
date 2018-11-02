public class Calendar {	
	/**
	* Given year as args[0]:
	* Prints the number of days in each of the 12 months
	**/ 

	public static void main(String args[]) {
		
		int getYear = Integer.parseInt(args[0]);		// Initiating values
		String whatYear = "";
		
		if (isLeapYear(getYear)) {				// Sets string regarding type of year
			whatYear = "leap";
		}
		else {
			whatYear = "common";
		}
	
		String output = ("Year " + getYear + " is a " + whatYear + " year");
		
		for (int i = 1; i<=12; i++) {				// Builds up output string with month && days no. 
			int month = i;
			output += ("\nMonth " + month + " has " + nDaysInMonth(month, getYear) + " days");
		}
		
		System.out.println(output);
	}
		 
	/**
	* Checks if a given year is a leap year
	*
	* @param year - year to answer whether it is leap or not
	* @return - true/false regarding given year
	**/
	private static boolean isLeapYear(int year) {
									// true  - leap year
									// false - common year
		 boolean isLeap = ((year % 4 == 0) && !(year % 100 == 0)) || (year % 400 == 0);
		 
		 return isLeap;
	}
	 
	
	/**
	* checks the amount of days a given month has
	* considering the number of month and whether the year is leap
	*
	* @param month - number of month (1-12) needed to checked for no. of days
	* @param year - the year the needed month is in
	* @return - amount of days of the given month
	**/
	private static int nDaysInMonth(int month, int year) {
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
					if (isLeapYear(year)) {		// Considers leap/not for February
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
