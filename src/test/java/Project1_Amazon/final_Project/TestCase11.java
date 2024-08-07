package Project1_Amazon.final_Project;
import static org.testng.Assert.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;
import resources.LaunchnQuit;
import resources.Test_Data;
public class TestCase11 extends  LaunchnQuit
{
	@Test(retryAnalyzer =resources.RetryFailed.class)
	public void checkOut() throws EncryptedDocumentException, IOException
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
		Amazon_SearchResult_Page a3=new Amazon_SearchResult_Page(driver);
		a1.searching();
		a3.selcting_1st_product();
		Amazon_product_Page a4=new Amazon_product_Page(driver);
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> p_cid= s1.iterator();
		String p_id=p_cid.next();
		String c_id=p_cid.next();
		driver.switchTo().window(c_id);
		
		a4.addingtocart();
		a4.goToCart();		
		Amazon_Cart_Page a5=new Amazon_Cart_Page(driver);
		a5.selectQuantity_dd();		a5.proceedToBuy();
		Amazon_CheckOut_Page a6=new Amazon_CheckOut_Page(driver);
		a6.selectAddress();
		a6.useThisAddress();
		a6.selectCashONDelevery();
		a6.useThisPaymentMethod();
		assertTrue(a6.chooseDeleveryOptions());
	}
}