package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryAnalyzerPractice {
	@Test(retryAnalyzer = vTiger.GenericUtilities.RetryAnalyzerImplementation.class)
	public void retryATest() {
		System.out.println("Executed");
		Assert.fail();
	}

	@Test
	public void retryTest() {
		System.out.println("Executed 1");
	}

}
