package Project1_Amazon.final_Project;
import static org.testng.Assert.*;
import java.util.Iterator;
import java.util.Set;
import org.testng.annotations.Test;
import resources.LaunchnQuit;

public class TestCase07 extends LaunchnQuit
{
	@Test(retryAnalyzer =resources.RetryFailed.class)
	public void productDetsils()
	{
		Amazon_Home_Page a1=new Amazon_Home_Page(driver);
		a1.searching();
		Amazon_SearchResult_Page a2=new Amazon_SearchResult_Page(driver);
		a2.selcting_1st_product();
		
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> p_cid= s1.iterator();
		String p_id=p_cid.next();
		String c_id=p_cid.next();
		driver.switchTo().window(c_id);
		Amazon_product_Page a3=new Amazon_product_Page(driver);
		
		String actual= a3.price();
		assertNotEquals(actual, "0");
		String productDetails=a3.description();
		assertEquals(productDetails.contentEquals(productDetails), true);
		assertNotEquals(a3.reviews(), null);
	}
}
