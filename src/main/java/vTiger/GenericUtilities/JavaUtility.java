package vTiger.GenericUtilities;

import java.util.Date;
import java.util.Random;

// - comment
/* multiline comment */

/**
 * - description This class consists of Generic methods related to Java
 * 
 * @author sharun
 *
 */

public class JavaUtility {
	/**
	 * This method will generate a random number for every run
	 * 
	 * @return
	 */
	public int getRandomNumber() {
		Random r = new Random();
		int value = r.nextInt(9999);
		return value;
	}

	/**
	 * This method will provide the system date
	 * 
	 * @return
	 */
	public String getSystemDate() {
		Date d = new Date();
		String value = d.toString();
		return value;
	}

	/**
	 * This method will return Date in specific format - date_month_year_time
	 * 
	 * @return
	 */
	public String getSystemDateInFormat() {
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2];
		String month = dArr[1];
		String year = dArr[5];
		String time = dArr[3].replace(":", "-");
		String dateInFormat = date + "_" + month + "_" + year + "_" + time;
		return dateInFormat;
	}

}
