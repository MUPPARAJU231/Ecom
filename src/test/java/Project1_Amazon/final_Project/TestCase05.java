package Project1_Amazon.final_Project;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import resources.LaunchnQuit;
import resources.Test_Data;

public class TestCase05 extends LaunchnQuit
{
	@Test(retryAnalyzer =resources.RetryFailed.class)
	public void searching_product() throws  IOException
	{
		Amazon_Home_Page a1=new Amazon_Home_Page(driver);
		a1.hoverover(driver);
		a1.signin_click();
		Amazon_Login_Page a2=new Amazon_Login_Page(driver);
		Test_Data ddt=new Test_Data();
		ddt.data_fetching();
		a2.enter_mobile();
		a2.continue_click();
		a2.pwd();
		a2.signin();
		a1.searching();
		Amazon_SearchResult_Page a4=new Amazon_SearchResult_Page(driver);
		a4.selcting_1st_product();
		
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> p_cid= s1.iterator();
		String p_id=p_cid.next();
		String c_id=p_cid.next();
		driver.switchTo().window(c_id);
		
		String actual= driver.getTitle();
		assertNotEquals(actual, "Amazon.in : shoe");
	}
}
