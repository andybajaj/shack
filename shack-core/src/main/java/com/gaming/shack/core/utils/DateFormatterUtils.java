/*
 * 
 */
package com.gaming.shack.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;

import com.gaming.shack.core.enums.DateFormatType;

// TODO: Auto-generated Javadoc
/**
 * The Class DateFormatterUtils.
 */
public class DateFormatterUtils {
	
	/**
	 * Format.
	 *
	 * @param date the date
	 * @return the date
	 * @throws ParseException the parse exception
	 */
	public static Date format(String date) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date convertDate = df.parse(date);
		return convertDate;
	}
	
	/**
	 * Format date.
	 *
	 * @param dateObj the date obj
	 * @param dateFormatType the date format type
	 * @return the string
	 */
	public static String formatDate(LocalDateTime dateObj, DateFormatType dateFormatType) {
		if(dateObj==null){
			return null;
		}
        String strDate = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatType.valueOf());
        
        strDate = dateObj.format(formatter);
       
        return strDate;
    }
	
	/**
	 * Format.
	 *
	 * @param date the date
	 * @param dateFormatType the date format type
	 * @return the local date time
	 * @throws ParseException the parse exception
	 */
	public static LocalDateTime format(String date,DateFormatType dateFormatType) throws ParseException {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatType.valueOf());
		 LocalDateTime convertDate = LocalDateTime.parse(date,formatter);
		return convertDate;
	}
	
	/**
	 * To ldt.
	 *
	 * @param date the date
	 * @return the local date time
	 */
	public static  LocalDateTime toLdt(Date date) {
	    GregorianCalendar cal = new GregorianCalendar();
	    cal.setTime(date);
	    ZonedDateTime zdt = cal.toZonedDateTime();
	    return zdt.toLocalDateTime();
	}

	/**
	 * From ldt.
	 *
	 * @param ldt the ldt
	 * @return the date
	 */
	public static  Date fromLdt(LocalDateTime ldt) {
	    ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.systemDefault());
	    GregorianCalendar cal = GregorianCalendar.from(zdt);
	    return cal.getTime();
	}
	
	    
}
