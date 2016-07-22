package com.technoglitz.date;

import static org.joda.time.DateTimeConstants.THURSDAY;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

// TODO: Auto-generated Javadoc
/**
 * The Class DateUtil.
 *
 * @author Varun Tamiri
 * The Class DateUtil.
 */
public class DateUtil {
	
	/**
	 * Checks if it is pay day.
	 *
	 * @param date the date String in format dd/MM/yyyy.
	 * @return true, if is pay day
	 */
	public boolean isPayDay(String date) {
		DateTime dateTime = DateTime.parse(date, DateTimeFormat.forPattern("dd/MM/yyyy"));
		return dateTime.getDayOfWeek()== THURSDAY && dateTime.getDayOfMonth() > 7 && dateTime.getDayOfMonth() <= 14;
	}
	
}