package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {

	@Test
	public void assertTest1() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		Assert.assertEquals(true, true);
		Assert.assertTrue(false);
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
	}
	
	@Test
	public void assertTest2() {
		SoftAssert sa = new SoftAssert();
		System.out.println("Step 1");
		
		Assert.assertTrue(true);
		
		System.out.println("Step 2");
		
		sa.assertEquals(true, true);
		
		System.out.println("Step 3");
		
		sa.assertTrue(false);
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		
		sa.assertTrue(false);
		System.out.println("Step 6");
		sa.assertAll();
	}

}
