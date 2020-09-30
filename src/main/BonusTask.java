package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BonusTask {
	
	// Map for getting number of days in a month
    private static Map<Integer, Integer> daysOfMonth;
    
    // Initializes the "daysOfMonth" map
    static void initializeMap() {
    	daysOfMonth = new HashMap<>();
    	daysOfMonth.put(1, 31);
    	daysOfMonth.put(2, 29);
    	daysOfMonth.put(3, 31);
    	daysOfMonth.put(4, 30);
        daysOfMonth.put(5, 31);
        daysOfMonth.put(6, 30);
        daysOfMonth.put(7, 31);
        daysOfMonth.put(8, 31);
        daysOfMonth.put(9, 30);
        daysOfMonth.put(10, 31);
        daysOfMonth.put(11, 30);
        daysOfMonth.put(12, 31);
    }
    
    // Return true if given year is a leap year
    static boolean isLeapYear(int year) {
    	if(year % 4 != 0) {
    		return false;
    	}
    	if(year % 100 != 0) {
    		return true;
    	}
    	if(year % 400 != 0) {
    		return false;
    	}
    	return true;
    }
	
	static void printBonusDatesBetween(int fromYear, int toYear) {
		if(toYear < fromYear || fromYear < 1000 || toYear > 10000) {
			System.out.println("Error: Invalid dates");
			return;
		}
		for(int i = fromYear; i < toYear; i++) {
			int month = (i % 10) * 10 + (i % 100) / 10;
			if(month > 0 && month < 13) {	// Check if month is valid
				int day = ((i / 100) % 10) * 10 + i / 1000;
				if(day > 0 && day <= daysOfMonth.get(month)) {	// Check if day (excluding February) is valid
					if(month != 2 || isLeapYear(i) || (!isLeapYear(i) && day <= 28)) {	// Check if February day is valid
						System.out.println(i + "-" + String.format("%02d", month) + "-" + String.format("%02d", day));
					}
				}
			}
		}
	}
	
	public static void main(String args[]) {
		initializeMap();
		printBonusDatesBetween(2010, 2015);
	}
}
