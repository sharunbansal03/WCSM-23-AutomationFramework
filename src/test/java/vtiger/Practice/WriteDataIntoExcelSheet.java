package vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		
		// Step 1: Load the file into File Input Stream - Java Readable Format
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		// Step 2: Create a WorkBook
		Workbook wb = WorkbookFactory.create(fis);
		
		// Step 3: Navigate to the required sheet
		Sheet sh = wb.getSheet("Organizations");
		
		// Step 4: Navigate to the required row
		Row rw = sh.getRow(4);
		
		// Step 5: Create required cell
		Cell ce = rw.createCell(7);
		
		// Step 6: Put/Write data inside the cell
		ce.setCellValue("QSpiders");
		
		// Step 7: Write into the file using File Output Stream
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
		wb.write(fos);
		
		System.out.println("data is added");
		System.out.println(ce.getStringCellValue());
	}

}
