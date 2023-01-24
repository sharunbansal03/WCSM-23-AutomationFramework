package vtiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtilities.BaseClass;

@Listeners(vTiger.GenericUtilities.ListenersImplentationClass.class)
public class DemoListenerTest extends BaseClass{

	@Test
	public void demoTest() {
		System.out.println("Demo test body");
	}
	
	@Test
	public void sampleTest() {
		System.out.println("Sample test body");
		Assert.fail();
	}
}
