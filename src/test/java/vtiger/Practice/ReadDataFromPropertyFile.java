package vtiger.Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		// step 1: read the file in java readable format using file input stream
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		// step 2: Create Object of Properties class from Java.util
		Properties pObj = new Properties();
		
		// step 3: load the file input stream
		pObj.load(fis);
		
		// step 4: provide the key and read the value
		String URL = pObj.getProperty("url");
		System.out.println(URL);
		
		String BROWSER = pObj.getProperty("browser");
		System.out.println(BROWSER);
	}

}
