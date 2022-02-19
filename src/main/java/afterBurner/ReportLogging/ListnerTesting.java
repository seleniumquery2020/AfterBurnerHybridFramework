package seleniumProgram;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class ListnerTesting {
	
	@Test(priority = 0)
	public void m1(){
		
		Assert.assertTrue(true);
	}
	
	@Test(priority = 1)
	public void m2() {

			Assert.assertEquals(true, false);
	}
	
   @Test(dependsOnMethods = {"m2"},priority =1 )
	public void m3(){
		System.out.println("Skip");
	}
   
   @Test(priority = 2)
   public void m4() {
	System.out.println("M4 Test");
}
}
