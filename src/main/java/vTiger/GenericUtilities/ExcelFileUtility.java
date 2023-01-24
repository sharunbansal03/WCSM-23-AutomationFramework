package vTiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consists of Generic Methods related to Excel File
 * 
 * @author sharu
 *
 */
public class ExcelFileUtility {
	/**
	 * This method reads data from Excel sheet and returns cell value
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelSheet(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell ce = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		String value = ce.getStringCellValue();
		return value;
	}

	/**
	 * This method will write data into excel sheet
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param cellValue
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void writeDataIntoExcelSheet(String sheetName, int rowNum, int cellNum, String cellValue)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Cell ce = wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		ce.setCellValue(cellValue);

		FileOutputStream fos = new FileOutputStream(IConstantsUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
	}

	/**
	 * This method will return the row count , ie, index of last row in sheet
	 * 
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheet).getLastRowNum();
	}

	/**
	 * This method reads multiple test data set from Excel sheet and returns it to
	 * the caller Used with DataProvider
	 * 
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDataFromExcel(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IConstantsUtility.ExcelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int lastRowIndex = sh.getLastRowNum(); // getLastRowNum - counts row from zero. so total rows-1
		int lastCelIndex = sh.getRow(0).getLastCellNum();// getLastCellNum - counts cell from zero but returns + 1. so,
															// total number of cells

		Object[][] data = new Object[lastRowIndex][lastCelIndex];

		for (int i = 0; i < lastRowIndex; i++) {
			for (int j = 0; j < lastCelIndex; j++) {
				data[i][j] = sh.getRow(i + 1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}

}
