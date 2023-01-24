package vtiger.Practice;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import vTiger.GenericUtilities.ExcelFileUtility;

public class ReadMultiExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelFileUtility eutil = new ExcelFileUtility();
		eutil.readMultipleDataFromExcel("MultipleOrganizations");
	}
}
