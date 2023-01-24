package vtiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {

	@Test(dataProvider = "getData")
	public void addProductToCartTest(String phone, int price, String model) {
		System.out.println(phone + " " + price + " " + model);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][3];

		data[0][0] = "Samsung";
		data[0][1] = 12000;
		data[0][2] = "S13";

		data[1][0] = "Iphone";
		data[1][1] = 40000;
		data[1][2] = "8plus";

		return data;
	}

}
