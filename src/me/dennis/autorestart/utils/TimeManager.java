package me.dennis.autorestart.utils;

import java.util.Calendar;

public class TimeManager {

	public static Long parseTimeStamp(String timestamp) {
		// Variable initializers
		String[] stringVars = timestamp.split(":");
		Integer H = 0;
		Integer M = 0;
		
		// Check if time stamp format is accepted
		if (stringVars.length != 2) {
			return null;
		}
		
		// Try to parse string time stamp to integers
		try {
			H = Integer.parseInt(stringVars[0]);
			M = Integer.parseInt(stringVars[1]);
		} catch(NumberFormatException e) {
			return null;
		}
		catch (Exception e) {
			Console.catchError(e, "CalendarDeserialize.parseTimeStamp():IntegerParser");
			return null;
		}
		
		// Check if integers are in range
		if (H < 0 || H > 23) {
			return null;
		}
		if (M < 0 || M > 59) {
			return null;
		}

		// Calendar creator
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, H);
		cal.set(Calendar.MINUTE, M);
		cal.set(Calendar.SECOND, 0);
		
		if (cal.getTimeInMillis() - Calendar.getInstance().getTimeInMillis() < 0) {
			cal.setTimeInMillis(cal.getTimeInMillis() + 86400000l);
		}
		
		return cal.getTimeInMillis();
	}
	
}
