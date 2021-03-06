/*
 * 
 */
package com.gaming.shack.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;

import com.gaming.shack.core.enums.DateFormatType;

// TODO: Auto-generated Javadoc
/**
 * The Class DateFormatterUtils.
 */
public class DateFormatterUtils {

	/** The Constant DATE_FORMAT_YYYY_MM_DD. */
	public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

	/**
	 * Format.
	 *
	 * @param date
	 *            the date
	 * @return the date
	 * @throws ParseException
	 *             the parse exception
	 */
	public static Date format(String date) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		Date convertDate = df.parse(date);
		return convertDate;
	}

	/**
	 * Format date.
	 *
	 * @param dateObj
	 *            the date obj
	 * @param dateFormatType
	 *            the date format type
	 * @return the string
	 */
	public static String formatDate(LocalDateTime dateObj, DateFormatType dateFormatType) {
		if (dateObj == null) {
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
	 * @param date
	 *            the date
	 * @param dateFormatType
	 *            the date format type
	 * @return the local date time
	 * @throws ParseException
	 *             the parse exception
	 */
	public static LocalDateTime format(String date, DateFormatType dateFormatType) throws ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatType.valueOf());
		LocalDateTime convertDate = LocalDateTime.parse(date, formatter);
		return convertDate;
	}

	/**
	 * To ldt.
	 *
	 * @param date
	 *            the date
	 * @return the local date time
	 */
	public static LocalDateTime toLdt(Date date) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		ZonedDateTime zdt = cal.toZonedDateTime();
		return zdt.toLocalDateTime();
	}

	/**
	 * From ldt.
	 *
	 * @param ldt
	 *            the ldt
	 * @return the date
	 */
	public static Date fromLdt(LocalDateTime ldt) {
		ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.systemDefault());
		GregorianCalendar cal = GregorianCalendar.from(zdt);
		return cal.getTime();
	}

	/**
	 * 
	 * @param dateInput
	 * @return
	 */
	public static Date toDate(String dateInput) throws ParseException {
		if (dateInput == null) {
			return null;
		}

		DateFormat formatter = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
		return formatter.parse(dateInput);

	}
	
	/**
	 * 
	 * @return
	 */
	public static LocalDate getCurrentDate() {
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDate localDate = localDateTime.toLocalDate() ;		
		return localDate ;
	}
	
	/**
	 * 
	 * @param dateIn
	 * @return
	 */
	public static long getDateDiffInYears(Date dateIn) {
		Instant instant = Instant.ofEpochMilli(dateIn.getTime()); 
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
		
		LocalDate localDateIn = localDateTime.toLocalDate(); 
		LocalDate currentDate = getCurrentDate() ; 
		return localDateIn.until(currentDate, ChronoUnit.YEARS) ;
	}
}
