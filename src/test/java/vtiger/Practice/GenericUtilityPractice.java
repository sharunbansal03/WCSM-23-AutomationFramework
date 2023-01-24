package vtiger.Practice;

import java.io.IOException;

import vTiger.GenericUtilities.ExcelFileUtility;
import vTiger.GenericUtilities.JavaUtility;
import vTiger.GenericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		JavaUtility jUtils = new JavaUtility();
		System.out.println("Random Number:- " + jUtils.getRandomNumber());

		String date = jUtils.getSystemDate();
		System.out.println("System date:- " + date);

		String dateInFormat = jUtils.getSystemDateInFormat();
		System.out.println("System date in format:- " + dateInFormat);

		PropertyFileUtility pObj = new PropertyFileUtility();
		System.out.println("Browser from property file:- " + pObj.readDataFromPropertyFile("browser"));
		System.out.println("URL fetched from Property file:- " + pObj.readDataFromPropertyFile("url"));

		ExcelFileUtility excObj = new ExcelFileUtility();
		String cellValue = excObj.readDataFromExcelSheet("Organizations", 4, 3);
		System.out.println("Value read from Excel sheet:- " + cellValue);

		excObj.writeDataIntoExcelSheet("Contacts", 7, 4, "Value from Script");
		System.out.println("Value written to excel sheet:- " + excObj.readDataFromExcelSheet("Contacts", 7, 4));

		System.out.println("Last row index in Organizations: " + excObj.getRowCount("Organizations"));

	}
}